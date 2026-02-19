package com.pbido.booktracker.adapter.input.mapper;

import com.pbido.booktracker.adapter.input.request.BookRequest;
import com.pbido.booktracker.core.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toDomain(BookRequest request);
}
