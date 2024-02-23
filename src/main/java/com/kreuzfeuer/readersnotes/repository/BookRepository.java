package com.kreuzfeuer.readersnotes.repository;


import com.kreuzfeuer.readersnotes.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getAllBookByUserEmail(String email);

    @Modifying
    @Query(value = "DELETE FROM book B " +
            "USING t_user U " +
            "WHERE b.id =:id AND " +
            "u.email=:email",
            nativeQuery = true)
    boolean deleteBookByIdAndUserEmail(@Param("id") Long id, @Param("email") String email);

   Optional <Book>  getBookByIdAndUserEmail (Long id, String email);
}

