package com.example.demo.library.repository;


import com.example.demo.library.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByGenreContainingIgnoreCase(String genre);
    List<Book> findByPriceGreaterThan(Double price);
    List<Book> findByPriceLessThan(Double price);

    Page<Book> findAll(Pageable pageable);
}
