package com.kreuzfeuer.readersnotes.domain.dto;

import com.kreuzfeuer.readersnotes.domain.entity.enums.BookRating;
import com.kreuzfeuer.readersnotes.domain.entity.enums.BookStatus;
import com.kreuzfeuer.readersnotes.domain.entity.Book;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
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
public class BookDTO {
    @Nullable
    private Long id;
    @NotBlank(message = "Name cannot be null")
    private String bookName;

    private String author;
    @Nullable
    private LocalDate dateAdded;

    private String description;

    private BookStatus status;

    private BookRating rating;

    public  static List<BookDTO> fromBooksToList(List<Book> books){
        List<BookDTO> dtos = new ArrayList<>();
        books.forEach(x -> dtos.add(
                BookDTO.builder()
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
    public static BookDTO fromBookToDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .dateAdded(book.getDateAdded())
                .description(book.getDescription())
                .rating(book.getRating())
                .status(book.getStatus())
                .build();
    }

    public static Book fromDTOtoBook(BookDTO book){
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
