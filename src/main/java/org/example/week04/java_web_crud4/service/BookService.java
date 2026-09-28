package org.example.week04.java_web_crud4.service;

import org.example.week04.java_web_crud4.domain.Book;
import org.example.week04.java_web_crud4.dto.*;
import org.example.week04.java_web_crud4.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository repository) { this.repository = repository; }

    public BookResponse create(BookRequest request) {
        // TODO 6: Book 생성 -> repository.save() -> BookResponse 반환
        return null;
    }
    public List<BookResponse> findAll() {
        // TODO 7: 모든 Book을 BookResponse 목록으로 변환하여 반환
        return List.of();
    }
    public BookResponse findById(Long id) {
        // TODO 8: 없는 id는 404 NOT_FOUND, 있으면 BookResponse 반환
        return null;
    }
    public BookResponse update(Long id, BookRequest request) {
        // TODO 9: 존재 여부 확인 -> 값 변경 -> repository.update() -> 응답 반환
        return null;
    }
    public void delete(Long id) {
        // TODO 10: 존재 여부 확인 후 삭제. 없는 id는 404 NOT_FOUND
    }
}