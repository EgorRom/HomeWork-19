package com.employebook.demoEmploye.service;

import com.employebook.demoEmploye.service.Employee;

import java.util.Collection;

public interface EmployeeService {


    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();


}





