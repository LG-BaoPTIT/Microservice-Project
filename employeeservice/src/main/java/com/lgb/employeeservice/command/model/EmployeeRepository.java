package com.lgb.employeeservice.command.model;

import com.lgb.employeeservice.command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
