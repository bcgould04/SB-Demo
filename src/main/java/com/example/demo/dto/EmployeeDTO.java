package com.example.demo.dto;

import com.example.demo.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Employee}
 */
@Value
@AllArgsConstructor
public class EmployeeDTO implements Serializable {
    int employee_id;
    String first_name;
    String last_name;
    String email;

    public String getFullName() {
        return first_name + " " + last_name;
    }

}