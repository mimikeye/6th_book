
package org.example.week04.java_web_crud4.controller;

import org.example.week04.java_web_crud4.dto.BookRequest;
import org.example.week04.java_web_crud4.dto.BookResponse;
import org.example.week04.java_web_crud4.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookWebController {

    private final BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
        System.out.println("BookWebController 생성 완료");
    }

    @GetMapping("/books")
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/books/new")
    public String newForm() {
        return "books/form";
    }

    @GetMapping("/books/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "books/edit";
    }

    @PostMapping("/books")
    public String create(@ModelAttribute BookRequest request) {
        bookService.create(request);
        return "redirect:/books";
    }
}
