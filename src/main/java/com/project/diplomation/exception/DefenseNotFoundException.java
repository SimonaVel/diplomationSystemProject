package com.project.diplomation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DefenseNotFoundException extends RuntimeException {
    public DefenseNotFoundException(String message) {
        super(message);
    }
}
