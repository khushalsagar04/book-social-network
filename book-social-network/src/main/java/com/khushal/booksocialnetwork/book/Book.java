package com.khushal.booksocialnetwork.book;

import com.khushal.booksocialnetwork.common.BaseEntity;
import com.khushal.booksocialnetwork.feedback.Feedback;
import com.khushal.booksocialnetwork.history.BookTransactionHistory;
import com.khushal.booksocialnetwork.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book")
    private List<BookTransactionHistory> histories;

    @Transient
    public double getRating(){
        if(feedbacks == null || feedbacks.isEmpty()){
            return 0.0;
        }
        var rating  = this.feedbacks.stream()
                .mapToDouble(Feedback::getFeedback)//here we might get an issue. in video at 4:20 hrs
                .average()
                .orElse(0.0);

        double roundedRating = Math.round(rating * 10.0) / 10.0;
        return roundedRating;
    }

























}
