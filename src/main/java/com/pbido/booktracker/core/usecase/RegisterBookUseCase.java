package com.pbido.booktracker.core.usecase;

import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.port.input.RegisterBookInputPort;
import com.pbido.booktracker.port.output.RepositoryOutputPort;


public class RegisterBookUseCase implements RegisterBookInputPort {

    private final RepositoryOutputPort repositoryOutputPort;

    public RegisterBookUseCase(RepositoryOutputPort repositoryOutputPort) {
        this.repositoryOutputPort = repositoryOutputPort;
    }

    @Override
    public int registerBook(Book book) {
        repositoryOutputPort.save(book);
        return 0;
    }
}
