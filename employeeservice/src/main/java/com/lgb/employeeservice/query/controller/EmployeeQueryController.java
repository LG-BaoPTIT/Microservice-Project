package com.lgb.employeeservice.query.controller;

import com.lgb.employeeservice.query.model.EmployeeReponseModel;
import com.lgb.employeeservice.query.queries.GetAllEmployeeQuery;
import com.lgb.employeeservice.query.queries.GetEmployeeQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{id}")
    public EmployeeReponseModel getEmployeeById(@PathVariable String id){
        GetEmployeeQuery getEmployeeQuery = new GetEmployeeQuery();
        getEmployeeQuery.setEmployeeId(id);

        EmployeeReponseModel employeeReponseModel = queryGateway.query(getEmployeeQuery, ResponseTypes.instanceOf(EmployeeReponseModel.class)).join();
        return employeeReponseModel;
    }

    @GetMapping
    public List<EmployeeReponseModel> getAllEmployees(){
        List<EmployeeReponseModel> result = queryGateway.query(new GetAllEmployeeQuery(),ResponseTypes.multipleInstancesOf(EmployeeReponseModel.class)).join();
        return result;
    }

}
