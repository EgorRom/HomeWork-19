package com.employebook.demoEmploye.controller;

import com.employebook.demoEmploye.service.Employee;
import com.employebook.demoEmploye.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("add")
    public Employee addEnployee(@RequestParam String firstName, @RequestParam String lastName) {

        return employeeService.add(firstName, lastName);
    }

    @GetMapping("remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return employeeService.find(firstName, lastName);
    }

    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }


}
