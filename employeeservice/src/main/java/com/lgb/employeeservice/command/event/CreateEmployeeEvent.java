package com.lgb.employeeservice.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeEvent {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;
}
