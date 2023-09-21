package com.lgb.employeeservice.query.projection;

import com.lgb.employeeservice.command.data.Employee;
import com.lgb.employeeservice.command.model.EmployeeRepository;
import com.lgb.employeeservice.query.model.EmployeeReponseModel;
import com.lgb.employeeservice.query.queries.GetAllEmployeeQuery;
import com.lgb.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {

    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryHandler
    public EmployeeReponseModel handle(GetEmployeeQuery getEmployeeQuery){
        EmployeeReponseModel employeeReponseModel = new EmployeeReponseModel();
        Employee employee = employeeRepository.getById(getEmployeeQuery.getEmployeeId());
        BeanUtils.copyProperties(employee, employeeReponseModel);
        return employeeReponseModel;
    }


    @QueryHandler
    public List<EmployeeReponseModel> handle(GetAllEmployeeQuery getAllEmployeeQuery){
        List<EmployeeReponseModel> listResult = new ArrayList<>();
        List<Employee> listEmployee = employeeRepository.findAll();
        listEmployee.forEach(e -> {
            EmployeeReponseModel employeeReponseModel = new EmployeeReponseModel();
            BeanUtils.copyProperties(e, employeeReponseModel);
            listResult.add(employeeReponseModel);
        });

        return listResult;
    }
}

