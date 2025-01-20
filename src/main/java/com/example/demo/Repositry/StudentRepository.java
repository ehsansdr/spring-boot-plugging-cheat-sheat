package com.example.demo.Repositry;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    public List<Student> findAllByFirstNameContaining(String name);
}
