package com.kreuzfeuer.readersnotes.service;


import com.kreuzfeuer.readersnotes.domain.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> getListBookByUserEmail(String email);


    boolean deleteBookByIdAndUserEmail(Long id, String email);

    Book save(Book book);

    Optional <Book> findBookByIdAndUserEmail(Long id,String email);
}
