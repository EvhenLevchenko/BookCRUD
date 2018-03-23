package com.test.demo;

import com.test.demo.domain.Autor;
import com.test.demo.domain.Book;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class BaseDomainTest {

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {

        Autor author = Autor.builder()
                .name("autor name")
                .book(Book.builder()
                        .name("book name")
                        .build())
                .build();

        entityManager.persist(author);
    }
}