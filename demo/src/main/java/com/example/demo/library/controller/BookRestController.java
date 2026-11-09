package com.example.demo.library.controller;

import com.example.demo.library.model.dto.book.BookResponse;
import com.example.demo.library.model.entity.Author;
import com.example.demo.library.model.entity.Book;
import com.example.demo.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {this.bookService = bookService;}

    @GetMapping("/books")
    public List<Book> getAllBooks() { return bookService.getAll();}

    @GetMapping("/paginated")
    public Page<BookResponse> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return bookService.getAllPaginated(page, size);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){return bookService.getById(id);}

    @PostMapping("/")
    public Book createBook(Book book) { return bookService.create(book); }

    @PutMapping("/update/{id}")
    public Book updateBook( @RequestBody Book book, @PathVariable Long id) { return bookService.update(book, id);}

    @DeleteMapping("/delete/{id}")
    public void deleteBook( @PathVariable Long id) { bookService.delete(id);}


}
