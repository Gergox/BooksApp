package com.hifiver.booksApp.dao;

import com.hifiver.booksApp.model.Book;

import java.util.List;

/**
 * Created by KYBL on 01.11.2017.
 */
public interface BookDao {
    Book findById(int id);

    void saveBook(Book book);

    public void saveOrUpdate(Book book);

    void deleteBookById(int id);

    List<Book> findAllBooks();

    Book findBookById(int id);
}
