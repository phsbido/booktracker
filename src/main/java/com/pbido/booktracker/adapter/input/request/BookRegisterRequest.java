package com.pbido.booktracker.adapter.input.request;

public record BookRegisterRequest(
        String title,
        String author,
        int status,
        int totalPages
) {
}
