package com.pbido.booktracker.adapter.input.controller;

import com.pbido.booktracker.adapter.input.mapper.BookMapper;
import com.pbido.booktracker.adapter.input.request.BookRegisterRequest;
import com.pbido.booktracker.adapter.input.request.BookRequest;
import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.port.input.RegisterBookInputPort;
import com.pbido.booktracker.port.input.SearchBookInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("booktracker/")
public class BooktrackerController {

    public final RegisterBookInputPort registerBookInputPort;
    public final SearchBookInputPort searchBookInputPort;
    public final BookMapper bookMapper;

    public BooktrackerController(RegisterBookInputPort registerBookInputPort, SearchBookInputPort searchBookInputPort, BookMapper bookMapper) {
        this.registerBookInputPort = registerBookInputPort;
        this.searchBookInputPort = searchBookInputPort;
        this.bookMapper = bookMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "register/")
    public ResponseEntity registerBook(@RequestBody BookRegisterRequest request) {
        registerBookInputPort.registerBook(bookMapper.toDomain(request));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "getBooks/")
    public ResponseEntity<List<Book>> getBooks(@RequestBody BookRequest request) {
        List<Book> listOfBooks = searchBookInputPort.getBookFromTitle(request.title());
        return new ResponseEntity<>(listOfBooks, HttpStatus.OK);
    }

}
