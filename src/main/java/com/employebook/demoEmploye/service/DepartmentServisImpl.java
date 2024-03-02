package com.employebook.demoEmploye.service;

import com.employebook.demoEmploye.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServisImpl implements DepartmentServise {
    private final EmployeeService employeeService;

    public DepartmentServisImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMinSalary(Integer department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMaxSalary(Integer department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(Integer department) {
        return
                employeeService.findAll().stream()
                        .filter(employee -> employee.getDepartment() == department)
                        .sorted(Comparator.comparing(Employee::getFullName))
                        .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployees() {
        return
                employeeService.findAll().stream()
                        .collect(groupingBy(Employee::getDepartment));
    }
}

