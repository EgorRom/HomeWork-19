package com.employebook.demoEmploye.service;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer department;


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartment() {
        return this.department;
    }

    public void setDepartment(Integer department) {

        this.department = department;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Employee(String firstName, String lastName, Integer salary, Integer department) {
        this.firstName =capitalize(firstName) ;
        this.lastName = capitalize(lastName);
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

}
