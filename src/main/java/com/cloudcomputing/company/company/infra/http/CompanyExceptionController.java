package com.cloudcomputing.company.company.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudcomputing.company.common.response.ErrorResponse;
import com.cloudcomputing.company.company.exception.NotFoundCompanyException;

@RestControllerAdvice
public class CompanyExceptionController {

    @ExceptionHandler(value = NotFoundCompanyException.class)
    public ResponseEntity<ErrorResponse> notFoundCompanyException(NotFoundCompanyException exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(404)
                                                         .message(exception.getMessage())
                                                         .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
