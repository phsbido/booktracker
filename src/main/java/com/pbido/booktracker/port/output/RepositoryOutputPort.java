package com.pbido.booktracker.port.output;

import com.pbido.booktracker.core.domain.Book;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryOutputPort {
    public void save(Book book);
    public List<Book> getBookByTitle(String title);
}
