package com.example.demo.library.service;


import com.example.demo.library.model.entity.Author;
import com.example.demo.library.model.entity.Book;
import com.example.demo.library.exceptions.AuthorIsRequiredException;
import com.example.demo.library.exceptions.NotFoundException;
import com.example.demo.library.repository.AuthorRepository;
import com.example.demo.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;
    private final AuthorRepository aurepo;

    public BookService(BookRepository repo, AuthorRepository aurepo) {
        this.repo = repo;
        this.aurepo = aurepo;
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book findById(Long id){
        Book book = repo.findById(id)
                    .orElseThrow(() -> new NotFoundException("not found"));

        return book;
    }


    public Book create(Book book){

        if(book.getAuthor() == null || book.getAuthor().getId() == null){
            throw new AuthorIsRequiredException("author is required");
        }

        Long authorID = book.getAuthor().getId();

        Author author = aurepo.findById(authorID)
                .orElseThrow(() -> new RuntimeException("author not found"));

        book.setAuthor(author);
        return repo.save(book);
    }

    public Book update(Book newbook, Long id){
        Book book = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        book.setId(newbook.getId());
        book.setAuthor(newbook.getAuthor());
        book.setTitle(newbook.getTitle());
        book.setPrice(newbook.getPrice());

        if(newbook.getAuthor() != null && newbook.getAuthor().getId() != null){
            Long authorID = newbook.getAuthor().getId();

            Author author = aurepo.findById(authorID)
                    .orElseThrow(() -> new NotFoundException("author not found"));

            aurepo.save(author);
        }

        return repo.save(book);
    }

    public void delete(Long id){
        Book book = repo.findById(id)
                        .orElseThrow(() -> new NotFoundException("book not found"));

        repo.delete(book);
    }
}
