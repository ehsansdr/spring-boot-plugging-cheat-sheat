package com.example.demo.Repostiory;

import com.example.demo.Tables.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//To access our Products, we’ll need a ProductRepository:
public interface CourseRepository extends JpaRepository<Course,Long> {

    //List<Course> findAllByCredit(Integer credit, Pageable pageable);

}
