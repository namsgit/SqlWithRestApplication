package com.naman.sqlrest.controller;

import com.naman.sqlrest.entity.Employee;
import com.naman.sqlrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.retrieveEmployees();
    }

    @GetMapping("/api/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/api/employees")
    public void saveEmployee(@RequestBody Employee employee){
        System.out.println(employee.getName());
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
    }

    @DeleteMapping("/api/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    @PutMapping("/api/employees/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
        Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
            employeeService.updateEmployee(employee);
        }
    }
}
