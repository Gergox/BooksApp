package com.hifiver.booksApp.service;

import com.hifiver.booksApp.model.Book;

import java.util.List;

/**
 * Created by KYBL on 01.11.2017.
 */
public interface BookService {
    Book findById(int id);

    void updateBook(Book book);

    void saveBook(Book book);

    void deleteBookById(int id);

    List<Book> findAllBooks();

    Book findBookById(int id);
}
