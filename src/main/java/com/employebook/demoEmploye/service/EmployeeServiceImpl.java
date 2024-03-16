package com.employebook.demoEmploye.service;

import com.employebook.demoEmploye.exception.EmployeeAlreadyAddedException;
import com.employebook.demoEmploye.exception.EmployeeBadRequest;
import com.employebook.demoEmploye.exception.EmployeeNotFoundException;
import com.employebook.demoEmploye.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName , Integer salary, Integer department) {

        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName ,salary,department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        validate(employee.getFirstName(),employee.getLastName());
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName , Integer salary, Integer department) {

        Employee employee = new Employee(firstName, lastName , salary, department);
        if (!employees.containsKey(employee.getFullName()))
            throw new EmployeeNotFoundException();
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName , Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName,salary,department);
        if (!employees.containsKey(employee.getFullName()))
            throw new EmployeeNotFoundException();

        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) {
            throw new EmployeeBadRequest("Некоректно введены ФИО сотрудника(недопустимые символы)");

        }
    }
}


