package com.Geekster.EmployeeAddress.Controllers;

import com.Geekster.EmployeeAddress.Models.Employee;
import com.Geekster.EmployeeAddress.Services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Add an Employee
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Get Employee using a specific ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    //Update Employee by a specific ID
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id , @RequestBody Employee employeeReq){
        return employeeService.updateEmployee(id, employeeReq);
    }

    //Delete Employee by a specific ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
