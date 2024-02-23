package com.kreuzfeuer.readersnotes.controller;


import com.kreuzfeuer.readersnotes.domain.dto.BookDTO;
import com.kreuzfeuer.readersnotes.domain.entity.Book;
import com.kreuzfeuer.readersnotes.domain.entity.User;
import com.kreuzfeuer.readersnotes.service.BookService;
import com.kreuzfeuer.readersnotes.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Books")
public class BooksController {

    private final BookService bookService;
    private final UserService userService;

    @Operation(
            description = "Get list of books for the user"
    )
    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks(Principal principal) {
        return ResponseEntity.ok(
                BookDTO.fromBooksToList(bookService.getListBookByUserEmail(principal.getName())));
    }
    @Operation( description = "Get book by id for the user")
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id, Principal principal) {
        Optional<Book> optBook = bookService.findBookByIdAndUserEmail(id, principal.getName());
        return optBook.map(book -> ResponseEntity.ok(
                BookDTO.fromBookToDTO(book))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(description = "Delete book by id for the user")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id, Principal principal) {

        boolean response = bookService.deleteBookByIdAndUserEmail(id, principal.getName());

        if (response)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();

    }

    @Operation(description = "Delete book by id for the user")
    @PostMapping("")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO, Principal principal) {
        Book book = BookDTO.fromDTOtoBook(bookDTO);
        book.setUser(userService.findByEmail(principal.getName()));
        bookService.save(book);
        return ResponseEntity.ok(BookDTO.fromBookToDTO(book));
    }

    @Operation(description = "Update book for the user")
    @PutMapping("")
    public ResponseEntity<BookDTO> updateBookById(@RequestBody BookDTO bookDTO, Principal principal) {

        Optional<Book> book = bookService.findBookByIdAndUserEmail(bookDTO.getId(), principal.getName());
        if (book.isEmpty()) {
            User user = userService.findByEmail(principal.getName());
            Book newBook = BookDTO.fromDTOtoBook(bookDTO);
            newBook.setUser(user);
            Book saved = bookService.save(newBook);
            return ResponseEntity.status(201).body(BookDTO.fromBookToDTO(saved));
        }
        bookDTO.updateBookFromDto(book.get());
        return ResponseEntity.ok(BookDTO.fromBookToDTO(book.get()));
    }


}