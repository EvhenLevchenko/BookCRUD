package com.test.demo.service;

import com.test.demo.domain.Book;
import com.test.demo.dto.BookDTO;
import com.test.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookDTO::fromBook)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookDTO addBook(BookDTO bookDTO) {
        Book saved = bookRepository.save(BookDTO.fromDTO(bookDTO));
        return BookDTO.fromBook(saved);
    }

    @Transactional
    public BookDTO addBooks(List<BookDTO> bookDTOs) {
//        List<BookDTO>
//        Book saved = bookRepository.save(BookDTO.fromDTO(bookDTO));
//
//        bookRepository.saveAll()
//        return BookDTO.fromBook(saved);
        return null;
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public static BookDTO fromBook(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }

    public static Book fromDTO(BookDTO bookDTO) {
        return Book.builder()
                .name(bookDTO.getName())
                .id(bookDTO.getId())
                .build();
    }

}
