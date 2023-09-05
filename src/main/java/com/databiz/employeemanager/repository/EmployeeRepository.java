package com.databiz.employeemanager.repository;

import com.databiz.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Object> findEmployeeById(Long id);
}
