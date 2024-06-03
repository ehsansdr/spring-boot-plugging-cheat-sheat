package com.example.demo.Repostiory;

import com.example.demo.Tables.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MangerRepository extends JpaRepository<Manager,Long> {
}
