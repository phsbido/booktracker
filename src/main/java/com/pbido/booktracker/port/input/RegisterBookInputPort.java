package com.pbido.booktracker.port.input;

import com.pbido.booktracker.core.domain.Book;

import java.sql.SQLException;

public interface RegisterBookInputPort {
    public int registerBook(Book domain);
}
