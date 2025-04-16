package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    // Constructor to initialize some students
    public StudentService() {
        studentList.add(new Student(1L, "Alice", "alice@example.com"));
        studentList.add(new Student(2L, "Bob", "bob@example.com"));
        studentList.add(new Student(3L, "Charlie", "charlie@example.com"));
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student addStudent(Student student) {
        student.setId((long) (studentList.size() + 1)); // Simulate auto-increment
        studentList.add(student);
        return student;
    }
}
