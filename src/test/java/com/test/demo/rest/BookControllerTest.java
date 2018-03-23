package com.test.demo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.dto.BookDTO;
import com.test.demo.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@ComponentScan
public class BookControllerTest {

    private final String BOOK_URL = "/books";

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private BookDTO firstBook = createUniqueBookDTO();
    private BookDTO secondBook = createUniqueBookDTO();

    @Before
    public void setUp() throws Exception {
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(firstBook, secondBook));
    }

    private BookDTO createUniqueBookDTO() {
        return BookDTO.builder()
                .id(new Random().nextInt())
                .name(UUID.randomUUID().toString())
                .build();
    }

    @Test
    public void getAll() throws Exception {
        String result = objectMapper.writeValueAsString(Arrays.asList(firstBook, secondBook));

        mvc.perform(get(BOOK_URL)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    public void addBook() throws Exception {
        String requestBody = objectMapper.writeValueAsString(firstBook);

        mvc.perform(post(BOOK_URL)
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBook() throws Exception {
        mvc.perform(delete(BOOK_URL + "/" + firstBook.getId()))
                .andExpect(status().isOk());
    }
}
