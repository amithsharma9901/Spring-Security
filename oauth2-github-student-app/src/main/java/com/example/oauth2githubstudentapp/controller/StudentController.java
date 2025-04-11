package com.example.oauth2githubstudentapp.controller;

import com.example.oauth2githubstudentapp.entity.Student;
import com.example.oauth2githubstudentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyDetails(@org.springframework.security.core.annotation.AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        if (email == null) {
            email = principal.getAttribute("login") + "@github.com";
        }

        List<Student> students = studentRepository.findByEmail(email);

        if (students.isEmpty()) {
            Student newStudent = new Student(principal.getAttribute("name"), email);
            studentRepository.save(newStudent);
            return ResponseEntity.ok(newStudent);
        } else {
            return ResponseEntity.ok(students.get(0));
        }
    }

    @GetMapping
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }
}