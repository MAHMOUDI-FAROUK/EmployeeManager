package com.databiz.employeemanager.Service;

import com.databiz.employeemanager.Exception.UserNotFoundException;
import com.databiz.employeemanager.model.Employee;
import com.databiz.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee (){
    return employeeRepository.findAll();

    }
    public Employee updateEmployee(Employee employee){
    return employeeRepository.save(employee);
    }
    public Employee findEmployeeById(Long id){
       return (Employee) employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
