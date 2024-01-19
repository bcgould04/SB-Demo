package com.example.demo.controllers.employee;

import com.example.demo.entity.employee.Employee;
import com.example.demo.error.employee.EmployeeNotFoundException;
import com.example.demo.service.employee.EmployeeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
// @RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @GetMapping("/employees/namesearch/{employeeLastName}")
    public List<Employee> getEmployeeByLastName(@PathVariable String employeeLastName) {
        List<Employee> employee = employeeService.findEmployeeByLastName(employeeLastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with last name " + employeeLastName + " not found" );
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee)  {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public String updateEmployeeById(@PathVariable int employeeId) {
        return "Employee updated";
    }

    @DeleteMapping ("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        return employeeService.deleteEmployeeById(employeeId) + " deleted";
    }

    @DeleteMapping ("/employees")
    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }
}
