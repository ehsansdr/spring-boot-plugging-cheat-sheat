package com.example.demo.Repostiory;

import com.example.demo.Tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}