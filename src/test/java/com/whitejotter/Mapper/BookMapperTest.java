package com.whitejotter.Mapper;

import com.whitejotter.entity.Book;
import com.whitejotter.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;

    @Test
    void selectAll(){
        List<Book> books = bookMapper.selectAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void selectByBook(){
        Book book = new Book("fmian","三体3","刘慈欣","2016-8-9","人民出版社","好看",2);
        System.out.println(bookMapper.selectByBook(book));
    }

    @Test
    void selectByTitle(){
        Book book = new Book("fmian","三体1","刘慈欣","2016-8-9","人民出版社","好看",2);
        Book book1 = bookMapper.selectByTitle(book);
    }

    @Test
    void selectAllByCategoryTest(){
        List<Book> books = bookMapper.selectAllByCategory(1);
        for (Book book : books)
            System.out.println(book.toString());

    }

    @Test
    void insertBookTest(){
        Book book1 = new Book("fmian","三a撒旦1","刘慈欣","2016-8-9","人民出版社","好看",2);
        bookMapper.insertBook(book1);
//        Book book2 = new Book("fmian","三体2","刘慈欣","2017-8-9","人民出版社","好看",2);
//        bookMapper.insertBook(book2);
//        Book book3 = new Book("fmian","三体3","刘慈欣","2018-8-9","人民出版社","好看",2);
//        bookMapper.insertBook(book3);
    };

    @Test
    void selectAllByTitleLikeOrAuthorLikeTest(){
        List<Book> books = bookMapper.selectAllByTitleLikeOrAuthorLike(null, null);
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Test
    void updateBookTest(){
        Book book = new Book(1,"fmian","瓦尔登湖","亨利·戴维·梭罗","2013-8-9","人民出版社","good",1);
        bookMapper.updateBook(book);
    }

    @Test
    void deleteById(){
        bookMapper.deleteById(6);
        bookMapper.deleteById(7);
    }

}
