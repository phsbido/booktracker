package com.pbido.booktracker.port.input;

import com.pbido.booktracker.core.domain.Book;

import java.util.List;

public interface SearchBookInputPort {
    public List<Book> getBookFromTitle(String bookTitle);
}
