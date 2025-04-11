package com.example.oauth2githubstudentapp.repository;

import com.example.oauth2githubstudentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByEmail(String email);
}