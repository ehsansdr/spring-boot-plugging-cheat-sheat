package com.example.demo.Repostiory;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle(".net")
                .credit(6)
                .build();

        /** because we have course as @Entity and it table we need to have this in:
         * @OneToOne(
         *             cascade = CascadeType.ALL
         *     )
         *
         * is CourseMaterial for Course
         * we can do this without exception
         *
         * SO IT IS IMPORTANT POINT
         */


        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.digikala.com")
                        .course(course)//if you have :
                        //optional = false//whenever you want to declare record (related field) required
                        //and sereneness to declare it not execute
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void printCourseMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        //check 6:05:34 of the video

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("courseMaterials = \n\t" + courseMaterials);
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");

    }

}