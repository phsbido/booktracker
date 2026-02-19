package com.pbido.booktracker.core.usecase;

import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.port.input.SearchBookInputPort;
import com.pbido.booktracker.port.output.RepositoryOutputPort;

import java.util.List;

public class SearchBookUseCase implements SearchBookInputPort {

    private final RepositoryOutputPort repositoryOutputPort;

    public SearchBookUseCase(RepositoryOutputPort repositoryOutputPort) {
        this.repositoryOutputPort = repositoryOutputPort;
    }

    @Override
    public List<Book> getBookFromTitle(String bookTitle) {
        return repositoryOutputPort.getBookByTitle(bookTitle);
    }
}
