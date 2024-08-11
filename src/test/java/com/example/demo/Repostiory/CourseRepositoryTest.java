package com.example.demo.Repostiory;

//import com.example.demo.Tables.Course;
//import com.example.demo.Tables.Guardian;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {

//    @Autowired
//    private CourseRepository courseRepository;

//    @Test
//    public void saveAllCourse(){
//        Course course = Course.builder()
//                .courseTitle("pathon")
//                .credit(8)
//                .build();
//
//        courseRepository.save(course);
//
//
//        System.out.println("**************************************************");
//        System.out.println("--------------------------------------------------");
//        System.out.println("course = \n\t" + course + "\nADDED");
//        System.out.println("--------------------------------------------------");
//        System.out.println("**************************************************");
//    }


//    @Test
//    public void printAllCourse(){
//        List<Course> courses = courseRepository.findAll();
//
//        System.out.println("**************************************************");
//        System.out.println("--------------------------------------------------");
//        System.out.println(courses.toString());
//        System.out.println("--------------------------------------------------");
//        System.out.println("**************************************************");
//    }
//    @Test
//    public void saveCourseWithTeacherObject(){
//        Teacher teacher = Teacher.builder()
//                .firstName("Ramin")
//                .lastName("Khandan")
//                .build();
//
//        Course course = Course.builder()
//                .courseTitle("dailyCodeBuffer")
//                .credit(6)
//                .teacher(teacher)
//                .build();
//
//
//        courseRepository.save(course);
//    }

//    @Test
//    public void findAllPagination(){
//        //https://www.baeldung.com/spring-data-jpa-pagination-sorting
//        //https://www.javatpoint.com/spring-mvc-pagination-example
//
//        Pageable firstPageWithThreeRecord =
//                (Pageable) PageRequest.of(0, 3, Sort.by("credit"));
//        Pageable secondPageWithThreeRecord =
//                (Pageable) PageRequest.of(1,2);
//
//        List<Course> courses = courseRepository.findAll((Sort) firstPageWithThreeRecord);
//
//        //Long totalElement = courseRepository.findAll(firstPageWithThreeRecord);
//        //Long totalPages = courseRepository.findAll(firstPageWithThreeRecord);
//
//        //System.out.println("totalPages : " + totalPages);
//        //System.out.println("totalElement : " + totalElement);
//        System.out.println("courses : " + courses);
//
//    }
//
//
//    @Test
//    public void saveCourseWithStudentAndTeacher(){
//
//        //we have bug here
//        //we can add teacher
//        //we can add course
//
//        //but student can not be added
//        //we can add student from student repository but not from here
//        //but student and course table does not get any thing
//
//        /**preblem solve:
//         *  because in addStudent();
//         *  we did not add student correctly:
//         *  public void addStudent(Student student){
//         *         //we add this method becuase we have @ManyToMany in field for students
//         *
//         *         if (students == null) {
//         *             this.students = new ArrayList<>();
//         *             System.out.println("\nthis.students = new ArrayList<>();\n");
//         *         }
//         *         else{
//         *             students.add(student);
//         *             System.out.println("\nstudents.add(student);\n");
//         *         }
//         *     }
//         *
//         *
//         *  the if condition if (students == null) execute and we do not have students.add(student); in there
//         *  so i add in both block to execute and
//         *  problem solved
//         *  */
//
//
//        Teacher teacher = Teacher.builder()
//                .firstName("a")
//                .lastName("felani")
//                .build();
//
//        Guardian guardian = Guardian.builder()
//                .name("hamid jan")
//                .email("hamid has email")
//                .mobile("23569")
//                .build();
//
//        Student student1 = Student.builder()
//                .firstName("ali")
//                .lastName("khalili")
//                .emailId("khalilikd@gmail.com")
//                .guardian(guardian)
//                .build();
//
//        Course course = Course.builder()//
//                .courseTitle("zamin shenasi")
//                .credit(12)
//                .teacher(teacher)
//                .build();
//
//        course.addStudent(student1);//create this by your self
//
//        courseRepository.save(course);
//
//        System.out.println("**************************************************");
//        System.out.println("--------------------------------------------------");
//        System.out.println("student1 : " + student1.toString() + "\nADDED");
//        System.out.println("course : " + course + "\nADDED");
//        System.out.println("--------------------------------------------------");
//        System.out.println("**************************************************");
//    }


}