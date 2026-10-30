package com.example.demo.library.model.dto.book;


import com.example.demo.library.model.entity.Author;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookRequest {

    private Long id;
    private String title;
    private String price;
    private Author author;

    public BookRequest(Long id, String title, String price, Author author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }
}
