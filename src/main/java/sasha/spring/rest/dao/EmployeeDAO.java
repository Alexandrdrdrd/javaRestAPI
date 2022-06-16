package sasha.spring.rest.dao;

import sasha.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int empId);

    void deleteEmployee(int empId);
}
