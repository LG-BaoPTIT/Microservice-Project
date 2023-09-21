package com.lgb.employeeservice.command.event;

import com.lgb.employeeservice.command.data.Employee;
import com.lgb.employeeservice.command.model.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventhandle {
    @Autowired
    EmployeeRepository employeeRepository;

    @EventHandler
    public void on(CreateEmployeeEvent event){
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(UpdateEmployeeEvent event){
        Employee employee = employeeRepository.getById(event.getEmployeeId());
        employee.setFirstName(event.getFirstName());
        employee.setLastName(event.getLastName());
        employee.setKin(event.getKin());
        employee.setIsDisciplined(event.getIsDisciplined());
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(DeleteEmployeeEvent event){
        employeeRepository.deleteById(event.getEmployeeId());
    }
}

