package com.example.demo.repostiory;

import com.example.demo.Tables.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository//To access our Products, we’ll need a ProductRepository:
public interface CourseRepository extends JpaRepository<Course,Long> {

    //List<Course> findAllByCredit(Integer credit, Pageable pageable);

}
