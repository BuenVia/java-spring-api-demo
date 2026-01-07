package org.mattdemo.project.book.service.impl;

import org.mattdemo.project.book.dao.BookDao;
import org.mattdemo.project.book.model.Book;
import org.mattdemo.project.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
//        Book book1 = new Book(1L, "Test Book", "Test Author");
//        Book book2 = new Book(2L, "Test Book 2", "Test Author 2");
//        List<Book> list_books = new ArrayList<Book>();
//        list_books.add(book1);
//        list_books.add(book2);
//        return list_books;
    }
}
