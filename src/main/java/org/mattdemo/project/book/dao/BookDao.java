package org.mattdemo.project.book.dao;

import org.mattdemo.project.book.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
}
