package com.pbido.booktracker.config;

import com.pbido.booktracker.adapter.input.mapper.BookMapper;
import com.pbido.booktracker.adapter.input.mapper.BookMapperImpl;
import com.pbido.booktracker.adapter.output.repository.H2DatabaseRepository;
import com.pbido.booktracker.core.usecase.RegisterBookUseCase;
import com.pbido.booktracker.core.usecase.SearchBookUseCase;
import com.pbido.booktracker.port.input.RegisterBookInputPort;
import com.pbido.booktracker.port.input.SearchBookInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RegisterBookInputPort registerBookInputPort() {
        return new RegisterBookUseCase(new H2DatabaseRepository());
    }

    @Bean
    public BookMapper bookMapper() {
        return new BookMapperImpl();
    }

    @Bean
    public SearchBookInputPort searchBookInputPort() {
        return new SearchBookUseCase(new H2DatabaseRepository());
    }
}
