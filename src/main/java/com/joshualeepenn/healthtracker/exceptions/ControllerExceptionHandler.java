package com.joshualeepenn.healthtracker.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.zone.ZoneRulesException;
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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException rnfe) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(List.of(rnfe.getMessage()));
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErrorMessage> handleTransactionException(TransactionException te) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(List.of(te.getMessage()));
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ZoneRulesException.class)
    public ResponseEntity<ErrorMessage> handleZoneRulesException(ZoneRulesException zr) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(List.of(zr.getMessage()));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException iae) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorMessage(List.of(iae.getMessage()));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Data
    public static class ErrorMessage {
        private List<String> errorMessage;
    }
}
