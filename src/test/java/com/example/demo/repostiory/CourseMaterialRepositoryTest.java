package com.example.demo.repostiory;

import com.example.demo.Tables.Course;
import com.example.demo.Tables.CourseMaterial;
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
                .courseTitle("DSA")
                .credit(6)
                .build();

        /** because we have :
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
                        .url("www.google.com")
                        .course(course)
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