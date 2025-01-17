package com.example.demo.Anotation;


import com.sun.tools.javac.Main;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoTesting {

    @Deprecated
    @Words(word = "first", value = 1)
    @Words(word = "second", value = 2)
    public static void newMethod() {
        AnnoTesting obj = new AnnoTesting();

        try {
            Class<?> c = obj.getClass();
            Method m = c.getMethod("newMethod");

            Annotation anno
                    = m.getAnnotation(MyRepeatedAnnos.class);// the annotation that has an array of the repeated class

            System.out.println(anno);

        } catch (NoSuchMethodException e) {
            System.out.println(e + "\nbe care full about the method name");
        }
    }
        public static void main(String[] args) {

            AnnoTesting annoTesting = new AnnoTesting();

            try {
                if (annoTesting.getClass().getMethod("newMethod").isAnnotationPresent(Words.class)) {
                    System.out.println("ffff");
                } else {
                    System.out.println("ttttt");
                }
                for (Method method : AnnoTesting.class.getMethods()){
                    if (method.isAnnotationPresent(Words.class)){
                        method.invoke(annoTesting);
                        // the annotation as a class object
                        Words annotation = method.getAnnotation(Words.class);
                        System.out.println(annotation.value() + " " + annotation.word());
                    }
                }
            }
            catch (NoSuchMethodException e){
                System.out.println(e);
            } catch (InvocationTargetException e){
                System.out.println(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


//		SpringApplication.run(DemoApplication.class, args);
        }
    public static void execution() {

        AnnoTesting annoTesting = new AnnoTesting();

        try {
            if (annoTesting.getClass().getMethod("newMethod").isAnnotationPresent(Words.class)) {
                System.out.println("ffff");
            } else {
                System.out.println("ttttt");
            }

            for (Method method : AnnoTesting.class.getDeclaredMethods()){
                if (method.isAnnotationPresent(Words.class)){
                    method.invoke(annoTesting);
                    // the annotation as a class object
                    Words annotation = method.getAnnotation(Words.class);
                    System.out.println(annotation.value() + " " + annotation.word());
                }
            }
        }
        catch (NoSuchMethodException e){
            System.out.println(e);
        } catch (InvocationTargetException e){
            System.out.println(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


//		SpringApplication.run(DemoApplication.class, args);
    }
}
