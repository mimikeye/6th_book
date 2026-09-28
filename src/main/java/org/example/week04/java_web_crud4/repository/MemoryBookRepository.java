package org.example.week04.java_web_crud4.repository;

import org.example.week04.java_web_crud4.domain.Book;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository {
    private final Map<Long, Book> store = new LinkedHashMap<>();
    private long sequence = 0L;

    @Override
    public Book save(Book book) {
        // TODO 1: 새로운 id를 생성하고 store에 저장한 뒤 book을 반환하세요.
        return null;
    }
    @Override
    public List<Book> findAll() {
        // TODO 2: 저장된 모든 Book을 List로 반환하세요.
        return List.of();
    }
    @Override
    public Optional<Book> findById(Long id) {
        // TODO 3: id에 해당하는 Book을 Optional로 반환하세요.
        return Optional.empty();
    }
    @Override
    public Book update(Book book) {
        // TODO 4: 같은 id의 Book을 수정하여 저장하고 반환하세요.
        return null;
    }
    @Override
    public void deleteById(Long id) {
        // TODO 5: id에 해당하는 Book을 삭제하세요.
    }
}