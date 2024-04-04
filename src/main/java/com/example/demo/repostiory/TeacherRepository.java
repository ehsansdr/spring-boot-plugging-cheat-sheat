package com.example.demo.repostiory;

import com.example.demo.Tables.Student;
import com.example.demo.Tables.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//To access our Products, we’ll need a ProductRepository:
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
