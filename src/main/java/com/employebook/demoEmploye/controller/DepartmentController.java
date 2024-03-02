package com.employebook.demoEmploye.controller;

import com.employebook.demoEmploye.service.DepartmentServise;
import com.employebook.demoEmploye.service.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentServise departmentServise;

    public DepartmentController(DepartmentServise departmentServise) {
        this.departmentServise = departmentServise;
    }

    @GetMapping("max-salary")
    public Employee findMaxSalary(@RequestParam Integer department) {
        return departmentServise.findMaxSalary(department);
    }

    @GetMapping("min-salary")
    public Employee findMinSalary(@RequestParam Integer department) {
        return departmentServise.findMinSalary(department);
    }

    @GetMapping(value = "/all", params = {" department"})
    public Collection<Employee> findEmployeeByDepartment(@RequestParam Integer department) {
        return departmentServise.findEmployeesByDepartment(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> findEmployee() {
        return departmentServise.findEmployees();
    }
}
