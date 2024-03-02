package com.employebook.demoEmploye.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServise {
    Employee findMinSalary(Integer department);

    Employee findMaxSalary(Integer department);

    Collection<Employee> findEmployeesByDepartment(Integer department);

    Map<Integer, List<Employee>> findEmployees();


}
