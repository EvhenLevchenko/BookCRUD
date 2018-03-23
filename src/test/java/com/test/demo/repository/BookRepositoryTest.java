package com.test.demo.repository;

import com.test.demo.BaseDomainTest;
import com.test.demo.domain.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BookRepositoryTest extends BaseDomainTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAll() {
        List<Book> all = bookRepository.findAll();

        assertThat(all).hasSize(1);
    }

    @Test
    public void getByName() {
        Book book = bookRepository.getByName("book name");

        assertThat(book).isNotNull();
    }

    @Test
    public void getByNameWhichNonExist() {
        Book book = bookRepository.getByName("empty");

        assertThat(book).isNull();
    }

}