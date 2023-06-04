package com.cloudcomputing.company.review.exception;

public class NotFoundReviewException extends RuntimeException {
    public NotFoundReviewException() {
        super("해당하는 review가 없습니다. ");
    }
}
