package com.example.demo.dao.employee;

import com.example.demo.entity.employee.Employee;

import java.util.List;

public interface EmployeeDAO {

    public Employee saveEmployee(Employee employee);

    public Employee findEmployeeById(Integer employeeId);

    public List<Employee> findAllEmployees();

    public List<Employee> findEmployeeByLastName(String lastName);

    public void updateEmployee(Employee employee);

    public String deleteEmployeeById(Integer employeeId);

    public int deleteAllEmployees();
}
