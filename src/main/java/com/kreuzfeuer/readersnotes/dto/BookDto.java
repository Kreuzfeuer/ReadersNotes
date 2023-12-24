package com.kreuzfeuer.readersnotes.dto;

import com.kreuzfeuer.readersnotes.entity.Book;
import com.kreuzfeuer.readersnotes.entity.enums.BookRating;
import com.kreuzfeuer.readersnotes.entity.enums.BookStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String bookName;

    private String author;

    private LocalDate dateAdded;

    private String description;

    private BookStatus status;

    private BookRating rating;

    public  static List<BookDto> fromBooksToList(List<Book> books){
        List<BookDto> dtos = new ArrayList<>();
        books.forEach(x -> dtos.add(
                BookDto.builder()
                        .id(x.getId())
                        .bookName(x.getBookName())
                        .author(x.getAuthor())
                        .dateAdded(x.getDateAdded())
                        .description(x.getDescription())
                        .rating(x.getRating())
                        .status(x.getStatus())
                        .build())
        );
        return dtos;
    }
    public static BookDto fromBookToDTO(Book book){
        return BookDto.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .dateAdded(book.getDateAdded())
                .description(book.getDescription())
                .rating(book.getRating())
                .status(book.getStatus())
                .build();
    }

    public static Book fromDTOtoBook(BookDto book){
        return Book.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .dateAdded(book.getDateAdded())
                .description(book.getDescription())
                .rating(book.getRating() != null ? book.getRating(): BookRating.NONE)
                .status(book.getStatus() != null ? book.status: BookStatus.PLANNED)
                .build();
    }
    public void updateBookFromDto(Book book){
        book.setBookName(this.getBookName());
        book.setDescription(this.getDescription());
        book.setAuthor(this.getAuthor());
        book.setRating(this.getRating());
        book.setStatus(this.getStatus());
    }
}
