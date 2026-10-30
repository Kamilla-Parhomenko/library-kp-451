package com.example.demo.library.controller;

import com.example.demo.library.model.entity.Book;
import com.example.demo.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {this.bookService = bookService;}

    @GetMapping("/books")
    public List<Book> getAllBooks() { return bookService.getAll();}

    @PostMapping("/books")
    public Book createBook(Book book) { return bookService.create(book); }

    @PutMapping("/books")
    public Book updateBook(Book book, Long id) { return bookService.update(book, id);}

    @DeleteMapping("/books")
    public void deleteBook(Long id) { bookService.delete(id);}


}
