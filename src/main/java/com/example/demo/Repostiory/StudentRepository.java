package com.example.demo.Repostiory;

import com.example.demo.Entity.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstNameContaining(String firstName); // the color of the default method will not be the same

    public void deleteById(long id);

    //****************************************************
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByLastName(String firstName);
}