package com.employebook.demoEmploye.service;

import com.employebook.demoEmploye.service.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee add(String firstName, String lastName, Integer salary, Integer department);

    Employee remove(String firstName, String lastName, Integer salary, Integer department);

    Employee find(String firstName, String lastName, Integer salary, Integer department);

    Collection<Employee> findAll();


}





