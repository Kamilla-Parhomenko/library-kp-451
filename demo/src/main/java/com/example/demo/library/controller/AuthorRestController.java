package com.example.demo.library.controller;

import com.example.demo.library.model.entity.Author;
import com.example.demo.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorRestController {

    private final AuthorService auservice;

    public AuthorRestController(AuthorService auservice){
        this.auservice = auservice;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return auservice.getAll();
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){
        return auservice.create(author);
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author, Long id){
        return auservice.update(author, id);
    }

    @DeleteMapping("/authors")
    public void deleteAuthor(Long id){

    }
}
