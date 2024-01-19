package com.example.demo.dao.student;

import com.example.demo.entity.student.Student;

import java.util.List;

public interface StudentDAO {

    public Student saveStudent(Student student);

    public Student findStudentById(Integer studentId);

    public List<Student> findAllStudents();

    public List<Student> findStudentByLastName(String lastName);

    public void updateStudent(Student student);

    public String deleteStudentById(Integer studentId);

    public int deleteAllStudents();
}
