package com.cloudcomputing.company.review.exception;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException() {
        super("글쓴이가 아닙니다.");
    }
}
