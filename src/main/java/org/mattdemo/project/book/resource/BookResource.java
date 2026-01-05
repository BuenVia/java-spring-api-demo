package org.mattdemo.project.book.resource;

import org.mattdemo.project.book.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookResource {

    @GetMapping
    public ResponseEntity<Book> getAllBooks() {
        Book book = new Book(1L, "Test Book", "Test Author");
        return ResponseEntity.ok(book);
    }

    @GetMapping("/secret")
    public ResponseEntity<String> secret() {
        return ResponseEntity.ok("RAAAAAHHHHHH");
    }

}
