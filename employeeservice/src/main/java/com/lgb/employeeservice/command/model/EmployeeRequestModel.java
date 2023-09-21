package com.lgb.employeeservice.command.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestModel {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;

}
