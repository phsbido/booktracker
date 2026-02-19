package com.pbido.booktracker.adapter.input.controller;

import com.pbido.booktracker.adapter.input.mapper.BookMapper;
import com.pbido.booktracker.adapter.input.request.BookRequest;
import com.pbido.booktracker.core.domain.Book;
import com.pbido.booktracker.port.input.RegisterBookInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("booktracker/")
public class BooktrackerController {

    public final RegisterBookInputPort registerBookInputPort;
    public final BookMapper bookMapper;

    public BooktrackerController(RegisterBookInputPort registerBookInputPort, BookMapper bookMapper) {
        this.registerBookInputPort = registerBookInputPort;
        this.bookMapper = bookMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "register/")
    public ResponseEntity registerBook(@RequestBody BookRequest request){
        registerBookInputPort.registerBook(bookMapper.toDomain(request));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Book> getBook(){

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
