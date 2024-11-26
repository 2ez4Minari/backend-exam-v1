package com.exam.demo.controller.exception;

import com.exam.demo.controller.dto.CustomerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<?> handleInvalidRequestException(InvalidRequestException invalidRequestException) {

        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(
                CustomerErrorResponse.builder()
                        .transactionStatusCode(HttpStatus.BAD_REQUEST.value())
                        .transactionStatusDescription(invalidRequestException.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException) {

        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(
                CustomerErrorResponse.builder()
                        .transactionStatusCode(HttpStatus.UNAUTHORIZED.value())
                        .transactionStatusDescription(notFoundException.getMessage())
                        .build()
        );
    }
}
