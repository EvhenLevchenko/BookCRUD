package com.test.demo.service;

import com.test.demo.BaseDomainTest;
import com.test.demo.dto.BookDTO;
import com.test.demo.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ComponentScan
public class BookServiceTest extends BaseDomainTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void getAllBooks() {
        List<BookDTO> all = bookService.getAllBooks();

        assertThat(all).hasSize(1);
        assertThat(4).isLessThan(5);
    }
}