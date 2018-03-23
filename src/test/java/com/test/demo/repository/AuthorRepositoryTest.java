package com.test.demo.repository;

import com.test.demo.BaseDomainTest;
import com.test.demo.domain.Autor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class AuthorRepositoryTest extends BaseDomainTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void findAll() {
        List<Autor> all = authorRepository.findAll();

        assertThat(all).hasSize(1);
    }
}