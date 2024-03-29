package com.employebook.demoEmploye.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeBadRequest extends RuntimeException {
    public EmployeeBadRequest(String message) {
        super(message);
    }
}
