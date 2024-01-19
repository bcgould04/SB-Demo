package com.example.demo.dao.student;

import com.example.demo.entity.student.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student findStudentById(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery(" FROM Student ", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s WHERE s.last_name = :lastName", Student.class);

        return query.setParameter("lastName", lastName).getResultList();
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public String deleteStudentById(Integer studentId) {
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
        return null;
    }

    @Override
    public int deleteAllStudents() {
        return entityManager.createQuery("DELETE FROM Student ").executeUpdate();
    }

}
