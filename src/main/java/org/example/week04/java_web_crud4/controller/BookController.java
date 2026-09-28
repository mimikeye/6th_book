package org.example.week04.java_web_crud4.controller;

import org.example.week04.java_web_crud4.dto.*;
import org.example.week04.java_web_crud4.service.BookService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService; }

    // TODO 11: POST /api/books - 생성 후 201 Created 반환
    // TODO 12: GET /api/books - 전체 조회
    // TODO 13: GET /api/books/{id} - 단건 조회
    // TODO 14: PUT /api/books/{id} - 수정
    // TODO 15: DELETE /api/books/{id} - 삭제 후 204 No Content 반환
}