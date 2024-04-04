package com.example.demo.repostiory;

import com.example.demo.Tables.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//To access our Products, we’ll need a ProductRepository:
public interface StudentRepository extends JpaRepository<Student,Long> {//<T, ID>T for entity and ID is id for you
                                                                        //we declare id filed in long so we put long

    /**https://www.javatpoint.com/jpa-jpql-introduction
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
     * https://www.tutorialspoint.com/jpa/jpa_jpql.htm
     * https://www.baeldung.com/spring-data-jpa-query*/

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String Name);/** if you want to find the record just eit part of the name use this
     and put that little part in parameter*/
    public List<Student> findByLastName(String lastName);
    public List<Student> findByLastNameNotNull();//?
    public List<Student> findByGuardianName(String GuardianFirstName);
    //public List<Student> findByLastnameAndFirstname(String lastName,String firstName);



    //JPQl
    /**the role of JPA is to transform JPQL into SQL.
     *
     * l or s or any other letters is optional but
     *
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
     *   if you want to get input to your jpql use "?(number of the method parameter from lft to right)"
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

    @Query("Select e from Student e where studentId = ?1")
    public Student getStudentFromId(Long studentId);

    @Query("Select e from Student e where studentId Between ?1 and ?2")//?1 and ?2 is included
    public List<Student> getRangeOfStudentFromId1ToId2(Long FromStudentId, Long TosStudentId);


    //NATIVE QUERY

    /**
     * if you want to use this type of @Query
     * be careful about this:
     * use the name of the able not the name if the filed in java class
     * and not the name of java class the name of table
     */
    @Query(
            value = "select * from tbl_student s where s.email_Address = ?1",
            nativeQuery = true
    )
    Student getStudentEmailAddressNative(String emailId);



    @Transactional/** important */
    @Modifying/** important because we want to update and changing */
    @Query(
            value = "UPDATE tbl_student\n" +
                    "SET last_name = :studentName " +
                    "WHERE email_Address = :emailIdOfTheStudent ;",// be careful about spaces
            nativeQuery = true
    )
    int updateTheStudentByGettingEmailAddress(@Param("studentName")String studentName,@Param("emailIdOfTheStudent") String emailId);

}
