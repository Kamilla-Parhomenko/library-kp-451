package com.example.demo.library.controller;

import com.example.demo.library.model.dto.author.AuthorResponse;
import com.example.demo.library.model.dto.book.BookResponse;
import com.example.demo.library.model.entity.Author;
import com.example.demo.library.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorRestController {

    private final AuthorService auservice;

    public AuthorRestController(AuthorService auservice){
        this.auservice = auservice;
    }

    @GetMapping("/")
    public List<Author> getAllAuthors(){
        return auservice.getAll();
    }

    @GetMapping("/paginated")
    public Page<AuthorResponse> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return auservice.getAllPaginated(page, size);
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){return auservice.getAuthorById(id);}

    @PostMapping("/")
    public Author createAuthor(@RequestBody Author author){
        return auservice.create(author);
    }

    @PutMapping("/update/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable Long id){
        return auservice.update(author, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(Long id){
        auservice.delete(id);
    }
}
