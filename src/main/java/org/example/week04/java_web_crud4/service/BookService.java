package org.example.week04.java_web_crud4.service;

import org.example.week04.java_web_crud4.domain.Book;
import org.example.week04.java_web_crud4.dto.*;
import org.example.week04.java_web_crud4.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public BookResponse create(BookRequest request) {
        // TODO 6: Book 생성 -> repository.save() -> BookResponse 반환
        Book book = new Book(
                null,
                request.title(),
                request.author(),
                request.price(),
                request.category(),
                request.isbn()
        );

        Book saved = repository.save(book);

        return new BookResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getPrice(),
                saved.getCategory(),
                saved.getIsbn()
        );
    }

    public List<BookResponse> findAll() {
        // TODO 7: 모든 Book을 BookResponse 목록으로 변환하여 반환
        return repository.findAll().stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getCategory(),
                        book.getIsbn()
                ))
                .toList();
    }

    public BookResponse findById(Long id) {
        // TODO 8: 없는 id는 404 NOT_FOUND, 있으면 BookResponse 반환
        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getCategory(),
                book.getIsbn()
        );
    }

    public BookResponse update(Long id, BookRequest request) {
        // TODO 9: 존재 여부 확인 -> 값 변경 -> repository.update() -> 응답 반환
        Book book = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setPrice(request.price());
        book.setCategory(request.category());
        book.setIsbn(request.isbn());

        Book updated = repository.update(book);

        return new BookResponse(
                updated.getId(),
                updated.getTitle(),
                updated.getAuthor(),
                updated.getPrice(),
                updated.getCategory(),
                updated.getIsbn()
        );
    }

    public void delete(Long id) {
        // TODO 10: 존재 여부 확인 후 삭제. 없는 id는 404 NOT_FOUND
        repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

        repository.deleteById(id);
    }
}