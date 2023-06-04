package com.cloudcomputing.company.review.exception;

public class NotMatchingCompanyException extends RuntimeException {
    public NotMatchingCompanyException() {
        super("company의 관계자가 아닙니다.");
    }
}
