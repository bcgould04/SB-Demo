package com.example.demo.dao.employee;

import com.example.demo.entity.employee.Employee;
import com.example.demo.entity.student.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

  /*  @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }*/

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery( "FROM Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }


    @Override
    public List<Employee> findEmployeeByLastName(String lastName) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee s WHERE s.last_name = :lastName", Employee.class);

        return query.setParameter("lastName", lastName).getResultList();
    }

    @Override
    public String deleteEmployeeById(Integer employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
        return null;
    }

    @Override
    public int deleteAllEmployees() {
        return entityManager.createQuery("DELETE FROM Employee ").executeUpdate();
    }

}
