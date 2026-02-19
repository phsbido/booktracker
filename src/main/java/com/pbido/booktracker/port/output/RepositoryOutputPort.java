package com.pbido.booktracker.port.output;

import com.pbido.booktracker.core.domain.Book;

import java.sql.SQLException;

public interface RepositoryOutputPort {
    public void save(Book book);
}
