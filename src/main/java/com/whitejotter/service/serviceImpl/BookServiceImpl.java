package com.whitejotter.service.serviceImpl;

import com.whitejotter.Mapper.BookMapper;
import com.whitejotter.Mapper.CategoryMapper;
import com.whitejotter.entity.Book;
import com.whitejotter.entity.Category;
import com.whitejotter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 获取全部书籍信息
     * @return List<Book>
     */
    @Override
    public List<Book> getAllBooks() {
        return bookMapper.selectAll();
    }

    /**
     * 根据分类获取书籍
     * @param cid
     * @return List<Book>
     */
    @Override
    public List<Book> listByCategory(int cid) {
        return bookMapper.selectAllByCategory(cid);
    }

    /**
     * 根据关键字查询书籍
     * @return List<Book>
     */
    @Override
    public List<Book> Search(String keywords) {
        return bookMapper.selectAllByTitleLikeOrAuthorLike(keywords,keywords);
    }

    /**
     * 增加或更新书籍
     * @return boolean
     */
    @Override
    public boolean addOrUpdate(Book book) {
        List<Book> books = bookMapper.selectByBook(book);
        if (!books.isEmpty()){
            book.setId(books.get(0).getId());
            return bookMapper.updateBook(book)>0;
        }
        return bookMapper.insertBook(book)>0;
    }

    /**
     * 根据id删除用户
     * @return boolean
     */
    @Override
    public boolean deleteBook(int id) {
        return bookMapper.deleteById(id)>0;
    }



}
