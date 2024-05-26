package com.khushal.booksocialnetwork.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BorrowedBookResponse {
    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private double rating;
    private boolean returned;
    private boolean returnApproved;
}
