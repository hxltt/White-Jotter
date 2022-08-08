package com.whitejotter.service;

import com.whitejotter.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    boolean addOrUpdate(Book book);

    boolean deleteBook(int id);

    List<Book> listByCategory(int cid);

    List<Book> Search(String keywords);
}
