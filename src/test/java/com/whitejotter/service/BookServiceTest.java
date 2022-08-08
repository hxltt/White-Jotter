package com.whitejotter.service;

import com.whitejotter.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    void getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        for (Book Book : allBooks) {
            System.out.println(Book.toString());
        }
    }

    @Test
    void addOrUpdate(){
        Book book = new Book("fmian","三体1","刘慈欣","2016-8-9","人民出版社","非常好看",2);
        System.out.println(bookService.addOrUpdate(book));
        System.out.println("____________________________________");
        System.out.println("____________________________________");
        Book book1 = new Book("fmian","平凡的世界","路遥","2001-08-09","人民出版社","平凡而伟大",2);
        System.out.println(bookService.addOrUpdate(book1));

    }

    @Test
    void deleteById(){
        System.out.println(bookService.deleteBook(22));
    }

    @Test
    void listByCategoryTest(){
        List<Book> books = bookService.listByCategory(2);
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


}
