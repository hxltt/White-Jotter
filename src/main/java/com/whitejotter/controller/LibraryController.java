package com.whitejotter.controller;

import com.whitejotter.entity.Book;
import com.whitejotter.service.BookService;
import com.whitejotter.util.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class LibraryController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    BookService bookService;

    /**
     * 查询所有书籍信息
     * @return List<Book>
     */
    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        logger.info("get All books");
        return bookService.getAllBooks();
    }

    /**
     * 根据书籍分类来查询书籍信息
     * @return List<Book>
     */
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> getBooksByCategory(@PathVariable("cid") int cid) {
        logger.info("get all books by" + cid);
        //如果cid分类为0的话查询所有的书籍，反之查询对应的书籍
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return bookService.getAllBooks();
        }
    }

    /**
     * 添加或更新书籍
     * @return Book
     */
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        logger.info("add or update book"+book.toString());
        bookService.addOrUpdate(book);
        return book;
    }

    /**
     * 删除书籍
     */
    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable("id") Integer id) {
        logger.info("delete book,id = " + id);
        bookService.deleteBook(id);
    }

    /**
     * 关键字搜索书籍
     * @return List<Book>
     */
    @GetMapping("/api/search")
    public List<Book> search(@RequestParam("keywords") String keywords) {
        logger.info("search book where keywords="+keywords);
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.getAllBooks();
        } else {
            return bookService.Search(keywords);
        }
    }


    /**
     * 存储封面信息
     * @return 封面存储路径imgURL
     */
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) {
        String folder = "D:/idea_workspace/baijuan/img"; //定义文件夹名字
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + Objects.requireNonNull(file.getOriginalFilename())
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            return "http://localhost:8443/api/file/" + f.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
