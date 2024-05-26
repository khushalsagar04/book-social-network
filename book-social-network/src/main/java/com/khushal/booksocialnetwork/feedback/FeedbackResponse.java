package com.khushal.booksocialnetwork.feedback;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedbackResponse {
    private Double rating;
    private String comment;
    private boolean ownFeedback;
}
