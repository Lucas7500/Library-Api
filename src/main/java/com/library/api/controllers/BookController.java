package com.library.api.controllers;

import com.library.api.domain.book.Book;
import com.library.api.repositories.BookRepository;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<Book> getAll() {
        return ResponseEntity.ok(new Book());
    }
}
