package sasha.spring.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sasha.spring.rest.entity.Employee;
import sasha.spring.rest.exception_handling.IncorrectEmployeeData;
import sasha.spring.rest.exception_handling.NoSuchEmployeeException;
import sasha.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee emp = employeeService.getEmployee(id);
        if (emp == null){
            throw new NoSuchEmployeeException("There is no employee with id = "+id + " in database");
        }
        System.out.println(emp);
        return emp;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

@DeleteMapping("/employees/{id}")
    public List<Employee> employees(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return showAllEmployees();
}
}
