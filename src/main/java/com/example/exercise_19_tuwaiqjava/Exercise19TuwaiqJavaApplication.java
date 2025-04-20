package com.example.exercise_19_tuwaiqjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise19TuwaiqJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exercise19TuwaiqJavaApplication.class, args);
    }

    //Create School management software
    //Teacher Class :
    //id , name , age , email , salary ( Add all required validation )
    //Address Class :
    //area , street , buildingNumber ( Add all required validation )
    //One To One relations:
    //Teacher - Address
    //Endpoints :
    //• Get all teachers
    //• Add new teacher
    //• Update teacher
    //• Delete teacher
    //• Add teacher address
    //• Update teacher address
    //• Delete teacher address
    //• Create endpoint that takes teacher id and return All
    //teacher details
}
