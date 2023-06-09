package com.cloudcomputing.company.review.infra.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudcomputing.company.common.response.ErrorResponse;
import com.cloudcomputing.company.review.exception.NotFoundReviewException;
import com.cloudcomputing.company.review.exception.NotMatchingCompanyException;
import com.cloudcomputing.company.review.exception.UnauthorizedAccessException;

@RestControllerAdvice
public class ReviewExceptionController {
    @ExceptionHandler(value = NotFoundReviewException.class)
    public ResponseEntity<ErrorResponse> notFoundReviewException(NotFoundReviewException exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(404)
                                                         .message(exception.getMessage())
                                                         .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(value = NotMatchingCompanyException.class)
    public ResponseEntity<ErrorResponse> notMatchingCompanyException(NotMatchingCompanyException exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(400)
                                                         .message(exception.getMessage())
                                                         .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(value = UnauthorizedAccessException.class)
    public ResponseEntity<ErrorResponse> unauthorizedAccessException(UnauthorizedAccessException exception) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                                                         .code(403)
                                                         .message(exception.getMessage())
                                                         .build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }
}
