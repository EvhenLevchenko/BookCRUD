package com.test.demo.rest;


import com.test.demo.dto.BookDTO;
import com.test.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getAll() {
        return bookService.getAllBooks();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<BookDTO> getOne(@PathVariable int id) {
//
//    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        BookDTO bookDTO1 = bookService.addBook(bookDTO);
        return ResponseEntity.ok(bookDTO1);
    }

    @PostMapping("/all")
    public ResponseEntity<BookDTO> addBooks(@RequestBody List<BookDTO> bookDTOs) {
        BookDTO bookDTO1 = bookService.addBooks(bookDTOs);
        return ResponseEntity.ok(bookDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}