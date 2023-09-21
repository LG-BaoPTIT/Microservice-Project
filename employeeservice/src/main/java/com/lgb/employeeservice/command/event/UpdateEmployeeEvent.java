package com.lgb.employeeservice.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeEvent {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;
}
