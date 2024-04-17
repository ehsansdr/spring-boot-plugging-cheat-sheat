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
                .emailId("ehsan123444@gmail.com")
                //.firstName("ehsan2")
                .lastName("sdr3")
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
        System.out.println("--------------------------------------------------");
        System.out.println("\n" + students + "\n");
        System.out.println("--------------------------------------------------");
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
        System.out.println("--------------------------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("mm");//self added
        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");

    }
    @Test
    public void printGuardianBaseOnName(){
        List<Student> students =
                studentRepository.findByGuardianName("akbar rahimi nia");//self added
        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("\n" + students + "\n");
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");

    }

    @Test
    public void printGuardianMobileBaseOnMobile(){
        List<Student> students =
                studentRepository.showMeAllRecordOfStudent();//self added

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("\n" + students);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("studentList : " + "\n" + studentList);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("ehsan1234@gamol.com");

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void printGetStudentFirstName(){
        List<String> student = studentRepository.showMeAllRecordOfFirstName();

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void printGetStudentLastName(){
        List<String> student = studentRepository.showMeAllRecordOfLastName();

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }
    @Test
    public void printStudentFromId(){
        Student student = studentRepository.getStudentFromId(4L);

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }
    @Test
    public void printRangeOfStudentFromIdToId(){
        List<Student> student = studentRepository.getRangeOfStudentFromId1ToId2(4L,12L);

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }
    @Test
    public void printStudentEmailAddressNative(){
        Student student = studentRepository.getStudentEmailAddressNative("tom4@gmail.com");

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void printStudentEmailAddressNativeParam(){
        int result= studentRepository
                .updateTheStudentByGettingEmailAddress("akbar ali","goergeefe@gmail.com");

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("result is : " + result);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

    @Test
    public void saveStudentInTest(){


        //without guardian you get exception
        Guardian guardian = Guardian.builder()
                .name("poya jan")
                .email("pouyahase email")
                .mobile("23569")
                .build();



        Student student1 = Student.builder()
                .firstName("mmmdrzae")
                .lastName("esmaillye")
                /**
                 * because we have
                 * uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
                 *                 name = "emailId_unique",
                 *                 columnNames = "email_Address"//the name of the column the real one
                 *         )
                 * in student class and we have set this on email make sure to enter unique
                 * instead you get exception
                 * */
                .emailId("esmaillyfkd@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student1);

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("student1 : " + student1 + "\nADDED");
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }

}