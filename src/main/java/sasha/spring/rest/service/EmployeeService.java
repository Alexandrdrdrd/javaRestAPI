package sasha.spring.rest.service;

import sasha.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int empId);

    public void deleteEmployee(int empId);
}
