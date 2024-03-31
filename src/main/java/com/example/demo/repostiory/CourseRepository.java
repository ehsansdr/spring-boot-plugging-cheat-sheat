package com.example.demo.repostiory;

import com.example.demo.Tables.Course;
import com.example.demo.Tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {


}
