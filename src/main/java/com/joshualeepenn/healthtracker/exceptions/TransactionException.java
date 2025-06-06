package com.joshualeepenn.healthtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TransactionException extends RuntimeException {

    public TransactionException(String message) {
        super(message);
    }

}
