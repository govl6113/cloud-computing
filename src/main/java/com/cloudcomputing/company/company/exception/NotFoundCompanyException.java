package com.cloudcomputing.company.company.exception;

public class NotFoundCompanyException extends RuntimeException {
    public NotFoundCompanyException(){
        super("해당하는 company가 없습니다.");
    }
}
