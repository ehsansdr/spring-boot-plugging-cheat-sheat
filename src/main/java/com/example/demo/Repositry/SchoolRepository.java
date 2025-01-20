package com.example.demo.Repositry;

import com.example.demo.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
