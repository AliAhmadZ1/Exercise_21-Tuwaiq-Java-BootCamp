package com.example.exercise_19_tuwaiqjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise19TuwaiqJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exercise19TuwaiqJavaApplication.class, args);
    }

                    //Exercise (JPA Relation Ill)
    //Create School management software

    //Teacher Class :
        //id , name , age , email , salary ( Add all required validation )
    // Address Class :
        //area , street , buildingNumber ( Add all required validation )
    //Course Class :
        // id , name ( all should not be empty )
    // Student Class :
        //ID , name , age , major ( all should not be empty )

    //One To One relations:
        //Teacher – Address
    //One To Many relations:
        //Teacher – Course
    //Many To Many relations:
        //Cousre - Student

    //Endpoints :
    //• Get all teachers
    //• Add new teacher
    //• Update teacher
    //• Delete teacher
    //• Add teacher address
    //• Update teacher address
    //• Delete teacher address
    //• Get all courses
    //• Add new course
    //• Update course
    //• Delete course
    //• Get all students
    //• Add new student
    //• Update student
    //• Delete student
    //• Create endpoint that takes teacher id and return All teacher details
    //• Create endpoint that take course id and return the teacher name for that class
    //• Create endpoint that takes student id and major and change the student major (changing the major will drop all the courses that the student attended to )
    //• Create endpoint that takes course id and return the student list

}
