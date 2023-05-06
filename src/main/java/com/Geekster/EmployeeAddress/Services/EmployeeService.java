package com.Geekster.EmployeeAddress.Services;

import com.Geekster.EmployeeAddress.Models.Employee;
import com.Geekster.EmployeeAddress.Repositories.IEmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepo employeeRepo;

    //Save Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    //Get all Employees
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    //Get Employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Employee with id : " + id +" not found"));
    }

    //Update employee using specific ID
    public Employee updateEmployee(Long id, Employee employeeReq) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeReq.getFirstName());
            employee.setLastName(employeeReq.getLastName());
            employee.setAddress(employeeReq.getAddress());
            employee.setEmail(employeeReq.getEmail());
            return employeeRepo.save(employee);
        }else{
            throw new EntityNotFoundException("Employee not found with id " + id);
        }
    }


    //delete employee using specific ID
    public ResponseEntity<Void> deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
