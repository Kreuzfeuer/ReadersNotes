package com.kreuzfeuer.readersnotes.service.impl;


import com.kreuzfeuer.readersnotes.entity.Book;
import com.kreuzfeuer.readersnotes.repository.BookRepository;
import com.kreuzfeuer.readersnotes.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getListBookByUserEmail(String email) {
        return bookRepository.getAllBookByUserEmail(email);
    }

    @Override
    @Transactional
    public boolean deleteBookByIdAndUserEmail(Long id, String email) {
       return bookRepository.deleteBookByIdAndUserEmail(id, email);

    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);

    }

    @Override
    public Optional<Book> findBookByIdAndUserEmail(Long id, String email) {
        return bookRepository.getBookByIdAndUserEmail(id, email);
    }

}
