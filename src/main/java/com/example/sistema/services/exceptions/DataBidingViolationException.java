package com.example.sistema.services.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataBidingViolationException extends DataIntegrityViolationException {

    public DataBidingViolationException(String message) {
        super(message);
    }
}
