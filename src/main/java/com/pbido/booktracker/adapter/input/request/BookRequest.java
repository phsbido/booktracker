package com.pbido.booktracker.adapter.input.request;

public record BookRequest(
        String title,
        String author,
        int status,
        int totalPages
) {
}
