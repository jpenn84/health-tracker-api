package com.joshualeepenn.healthtracker.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException cve) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(cve.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Data
    public static class ErrorMessage {
        private List<String> errorMessage;
    }
}
