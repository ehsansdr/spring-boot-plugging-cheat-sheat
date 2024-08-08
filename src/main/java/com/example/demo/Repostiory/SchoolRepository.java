package com.example.demo.Repostiory;

import com.example.demo.Tables.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
    /** you can use the save() and save all method without declaring them in repository interface */


}