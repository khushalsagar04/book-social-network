package com.khushal.booksocialnetwork.history;

import com.khushal.booksocialnetwork.book.Book;
import com.khushal.booksocialnetwork.common.BaseEntity;
import com.khushal.booksocialnetwork.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
public class BookTransactionHistory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private boolean returned;
    private boolean returnApproved;

}
