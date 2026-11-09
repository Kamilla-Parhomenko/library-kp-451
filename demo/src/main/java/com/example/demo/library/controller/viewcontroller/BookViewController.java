package com.example.demo.library.controller.viewcontroller;

import com.example.demo.library.model.dto.book.BookRequest;
import com.example.demo.library.service.AuthorService;
import com.example.demo.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/books")
public class BookViewController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to our library");
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookRequest", new BookRequest());
        model.addAttribute("authors",  authorService.getAll());

        return "books/create";
    }
}
