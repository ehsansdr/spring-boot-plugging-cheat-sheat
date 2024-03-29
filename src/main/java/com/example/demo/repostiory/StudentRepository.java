package com.example.demo.repostiory;

import com.example.demo.Tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {//<T, ID>T for entity and ID is id for you
                                                                        //we declare id filed in long so we put long

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String Name);/** if you want to find the record just eit part of the name use this
     and put that little part in parameter*/
    public List<Student> findByLastName(String lastName);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String GuardianFirstName);


}
