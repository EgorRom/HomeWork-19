package com.employebook.demoEmploye.exception;

public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException() {
        super("Штат сотрудников полный");
    }
}
