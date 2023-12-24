package com.kreuzfeuer.readersnotes.entity;


import com.kreuzfeuer.readersnotes.entity.enums.BookRating;
import com.kreuzfeuer.readersnotes.entity.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false )
    private String bookName;

    private String author;

    @Column(name = "date", nullable = false)
    private LocalDate dateAdded;

    private String description;

    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.PLANNED;

    @Enumerated(EnumType.STRING)
    private BookRating rating = BookRating.NONE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    private void init(){
        dateAdded = LocalDate.now();
    }
}
