package com.hifiver.booksApp.dao;

import com.hifiver.booksApp.model.Book;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "bookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

    @Override
    public Book findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveBook(Book book) {
        persist(book);
    }

    @Override
    public void saveOrUpdate(Book book) {
        super.saveOrUpdate(book);
    }

    @Override
    public void deleteBookById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM books.booklist WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> findAllBooks() {
        Criteria criteria = createEntityCriteria();
        return (List<Book>) criteria.list();
    }

    @Override
    public Book findBookById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Book) criteria.uniqueResult();
    }
}
