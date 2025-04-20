package com.example.exercise_19_tuwaiqjava.Repository;

import com.example.exercise_19_tuwaiqjava.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);

}
