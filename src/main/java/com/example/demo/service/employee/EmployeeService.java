package com.example.demo.service.employee;

import com.example.demo.dao.employee.EmployeeDAO;
import com.example.demo.entity.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@Component*/
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

   /* @Autowired
    public EmployeeService(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }*/

    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    public Employee findEmployeeById(Integer employeeId) {
        return employeeDAO.findEmployeeById(employeeId);
    }

    public List<Employee> findEmployeeByLastName(String lastName) {
        return employeeDAO.findEmployeeByLastName(lastName);
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    public Employee deleteEmployeeById(Integer employeeId) {
        employeeDAO.deleteEmployeeById(employeeId);
        return null;
    }

    @Transactional
    public String deleteAllEmployees() {
        employeeDAO.deleteAllEmployees();
        return "All employees deleted";
    }
}
