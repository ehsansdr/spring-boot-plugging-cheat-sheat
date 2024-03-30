package com.example.demo.repostiory;

import com.example.demo.Tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {//<T, ID>T for entity and ID is id for you
                                                                        //we declare id filed in long so we put long

    /**https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html */
    /**https://www.tutorialspoint.com/jpa/jpa_jpql.htm*/

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String Name);/** if you want to find the record just eit part of the name use this
     and put that little part in parameter*/
    public List<Student> findByLastName(String lastName);
    public List<Student> findByLastNameNotNull();//?
    public List<Student> findByGuardianName(String GuardianFirstName);
    //public List<Student> findByLastnameAndFirstname(String lastName,String firstName);



    //JPQl
    /**l or s or any other letters is optional but
     * BR CAREFUL:
     * the annotation parameter that comes in () is statement based part and have rules
     * put the java class name of that table not the name of that the method would not execute
     * after java class name of that table after "from" put the letter that you put first
     *
     * if you want the value of the specific column have this :
     *   (specific letter).(the name of that class filed that create column)
     *   e.lastName    ("lastName" is name the column)
     *
     *   BE CAREFUL about the return type
     *   create List<(the type of that field that in column and store data in that field of record)>
     *   lastName is String and you see that in student class
     *   private String firstName;
     *
     * */
    @Query("select s from Student s where emailId = ?1")
    Student getStudentByEmailAddress(String EmailId);


    @Query("select g from Student g")
    public List<Student> showMeAllRecordOfStudent();

    @Query("Select e.firstName from Student e")
    public List<String> showMeAllRecordOfFirstName();


    @Query("Select e.lastName from Student e")
    //"Select e.lastName from Student e ORDER BY studentId desc"
    public List<String> showMeAllRecordOfLastName();




}
