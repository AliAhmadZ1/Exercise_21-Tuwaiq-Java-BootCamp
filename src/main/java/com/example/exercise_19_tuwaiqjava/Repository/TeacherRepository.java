package com.example.exercise_19_tuwaiqjava.Repository;

import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);

    Teacher findTeacherByEmail(String email);
}
