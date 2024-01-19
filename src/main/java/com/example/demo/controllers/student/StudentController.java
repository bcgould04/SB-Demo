package com.example.demo.controllers.student;

import com.example.demo.entity.student.Student;
import com.example.demo.error.student.StudentNotFoundException;
import com.example.demo.service.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return student;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student)  {
        return studentService.saveStudent(student);
    }

    @PostMapping("/students/{id}")
    public String updateStudentById(@PathVariable int id) {
        return "Student updated";
    }

    @DeleteMapping ("/students/{id}")
    public String deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id) + " deleted";
    }

    @DeleteMapping ("/students")
    public String deleteAllStudents() {
        return studentService.deleteAllStudents();
    }
}
