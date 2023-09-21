package com.lgb.employeeservice.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteEmployeeEvent {
    private String employeeId;
}
