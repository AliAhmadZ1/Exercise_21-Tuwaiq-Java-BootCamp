package com.example.exercise_19_tuwaiqjava.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    // Student Class :
    //ID , name , age , major ( all should not be empty )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
    @NotEmpty
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;

}
