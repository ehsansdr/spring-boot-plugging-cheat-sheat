package com.example.demo.repostiory;

import com.example.demo.Tables.Guardian;
import com.example.demo.Tables.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest/** important*/
//@DataJpaTest//help to test your repository layer
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test//if you do not have this you can run test method
    public void saveStudent(){
        //because we have @Builder in Entity class we can do this
        Student student = Student.builder()
                .emailId("ehsan1234@gmail.com")
                .firstName("ehsan2")
                .lastName("sdr2")
                //.guardianName("ali")
                //.guardianEmail("guardianEmail@gamil.com")
                //.guardianMobile("5999999999")
                .build();//DO NOT FORGET THIS


        studentRepository.save(student);
    }


    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("akbar rahimi nia")
                .email("akbar@gamol.com")
                .mobile("032658")
                .build();

        Student student = Student.builder()
                .firstName("mmd")
                .lastName("mmdi nia")
                .emailId("mmdsli@gamol.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("mmd");//self added
        System.out.println("**************************************************");
        System.out.println("\n" + students + "\n");
        System.out.println("**************************************************");
    }

//    @Test
//    public void findByFirstNameAndLastName(){
//        List<Student> students =
//                studentRepository.findByLastnameAndFirstname("sdr2","ehsan2");//self added
//
//        System.out.println("\n" + students + "\n");
//    }
    @Test
    public void printStudentByLastName(){
        List<Student> students =
                studentRepository.findByLastName("mmdi nia");//self added
        System.out.println("**************************************************");
        System.out.println(students);
        System.out.println("**************************************************");
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("mm");//self added
        System.out.println("**************************************************");
        System.out.println(students);
        System.out.println("**************************************************");

    }
    @Test
    public void printGuardianBaseOnName(){
        List<Student> students =
                studentRepository.findByGuardianName("akbar rahimi nia");//self added
        System.out.println("**************************************************");
        System.out.println("\n" + students + "\n");
        System.out.println("**************************************************");

    }

    @Test
    public void printGuardianMobileBaseOnMobile(){
        List<Student> students =
                studentRepository.showMeAllRecordOfStudent();//self added

        System.out.println("**************************************************");
        System.out.println("\n" + students + "\n");
        System.out.println("**************************************************");
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("**************************************************");
        System.out.println("studentList : " + "\n" + studentList + "\n");
        System.out.println("**************************************************");
    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("ehsan1234@gamol.com");

        System.out.println("**************************************************");
        System.out.println("\n" + student + "\n");
        System.out.println("**************************************************");
    }

    @Test
    public void printGetStudentFirstName(){
        List<String> student = studentRepository.showMeAllRecordOfFirstName();

        System.out.println("**************************************************");
        System.out.println("\n" + student + "\n");
        System.out.println("**************************************************");
    }

    @Test
    public void printGetStudentLastName(){
        List<String> student = studentRepository.showMeAllRecordOfLastName();

        System.out.println("**************************************************");
        System.out.println("\n" + student + "\n");
        System.out.println("**************************************************");
    }

}