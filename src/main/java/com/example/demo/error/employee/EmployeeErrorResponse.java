package com.example.demo.error.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
