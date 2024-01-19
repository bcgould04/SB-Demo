package com.example.demo.service.student;

import com.example.demo.dao.student.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.student.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<Student> findAllStudents() {
        return studentDAO.findAllStudents();
    }

    public Student findStudentById(Integer studentId) {
        return studentDAO.findStudentById(studentId);
    }

    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Transactional
    public Student deleteStudentById(Integer studentId) {
        studentDAO.deleteStudentById(studentId);
        return null;
    }

    @Transactional
    public String deleteAllStudents() {
        studentDAO.deleteAllStudents();
        return "All students deleted";
    }
}
