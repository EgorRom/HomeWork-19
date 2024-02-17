package com.employebook.demoEmploye.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super("Сотрудник не найден");
    }
}
