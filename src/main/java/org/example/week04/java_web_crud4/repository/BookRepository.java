package org.example.week04.java_web_crud4.repository;

import org.example.week04.java_web_crud4.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book update(Book book);
    void deleteById(Long id);
}