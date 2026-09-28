package org.example.week04.java_web_crud4.dto;

public record BookRequest(
        String title,
        String author,
        int price,
        String category,
        String isbn
) {}