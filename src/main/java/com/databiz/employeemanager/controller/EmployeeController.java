package com.databiz.employeemanager.controller;

import com.databiz.employeemanager.Service.EmployeeService;
import com.databiz.employeemanager.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeDetails (){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeDetails(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployeeDetails(@RequestBody Employee employee) {
        Employee newemployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newemployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee) {
        Employee updateemployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(updateemployee, HttpStatus.OK);
    }
}
