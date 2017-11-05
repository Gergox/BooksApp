package com.hifiver.booksApp.service;

import com.hifiver.booksApp.dao.BookDao;
import com.hifiver.booksApp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public void updateBook(Book book) {
        Book entity = bookDao.findBookById(book.getId());
        if (entity != null) {
            entity.setAuthor(book.getAuthor());
            entity.setDescription(book.getDescription());
            entity.setNumberInRating(book.getNumberInRating());
            entity.setTitle(book.getTitle());
        }
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }
}
