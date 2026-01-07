package org.mattdemo.project.book.dao.impl;

import org.mattdemo.project.book.dao.BookDao;
import org.mattdemo.project.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {

    private Map<Long, Book> db = new HashMap<>();

    public BookDaoImpl() {
        db.put(1L, new Book(1L, "Test Book", "Test Author"));
        db.put(2L, new Book(2L, "Test Book 2", "Test Author 2"));
        db.put(3L, new Book(3L, "Test Book 3", "Test Author 3"));
    }

    public List<Book> findAll() {
        return new ArrayList<>(db.values());
    }

}
