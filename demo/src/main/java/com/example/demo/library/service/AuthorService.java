package com.example.demo.library.service;

import com.example.demo.library.model.entity.Author;
import com.example.demo.library.exceptions.CantBeNullException;
import com.example.demo.library.exceptions.NotFoundException;
import com.example.demo.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository aurepo;

    public AuthorService(AuthorRepository aurepo) {
        this.aurepo = aurepo;
    }

    public List<Author> getAll() {return aurepo.findAll();}

    public Author findById(Long id){
        Author author = aurepo.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));
        return author;
    }

    public Author create(Author author){

        if(author.getId() == null){
            throw new CantBeNullException("this field cannot be null");
        }

        return aurepo.save(author);
    }

    public Author update(Author newauthor, Long id){

        Author author = aurepo.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));

        author.setId(newauthor.getId());
        author.setFullname(newauthor.getFullname());
        author.setCountry(newauthor.getCountry());
        author.setBirthdate(newauthor.getBirthdate());

        return aurepo.save(author);
    }

    public void delete(Long id){
        Author author = aurepo.findById(id)
                .orElseThrow(() -> new NotFoundException("not found"));

        aurepo.delete(author);
    }
}
