package com.test.demo.dto;

import com.test.demo.domain.Book;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO implements Serializable {

    private int id;
    private String name;

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