package com.khushal.booksocialnetwork.book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {

    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String owner;
    private byte[] cover;
    private double rating;
    private boolean archived;
    private boolean shareable;
}
