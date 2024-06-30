package com.example.demo.Repostiory;

import com.example.demo.Tables.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//To access our Products, we’ll need a ProductRepository:
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {




}
