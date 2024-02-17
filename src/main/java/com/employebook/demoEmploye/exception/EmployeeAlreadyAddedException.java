package com.employebook.demoEmploye.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeAlreadyAddedException extends RuntimeException{

    public EmployeeAlreadyAddedException() {
        super("Сотрудник уже есть в базе данных");
    }
}
