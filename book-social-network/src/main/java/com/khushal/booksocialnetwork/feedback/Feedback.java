package com.khushal.booksocialnetwork.feedback;

import com.khushal.booksocialnetwork.book.Book;
import com.khushal.booksocialnetwork.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
public class Feedback extends BaseEntity {
    private Double feedback;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
