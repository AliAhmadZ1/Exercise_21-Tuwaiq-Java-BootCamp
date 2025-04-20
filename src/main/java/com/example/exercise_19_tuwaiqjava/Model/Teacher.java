package com.example.exercise_19_tuwaiqjava.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    //Teacher Class :
    //id , name , age , email , salary ( Add all required validation )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;
    @NotNull
    @Positive(message = "age should be greater than 1")
    private Integer age;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @PositiveOrZero(message = "salary cannot be negative")
    private Integer salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> course;

}
