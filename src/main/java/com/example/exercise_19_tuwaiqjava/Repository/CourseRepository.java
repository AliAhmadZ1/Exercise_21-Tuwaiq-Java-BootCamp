package com.example.exercise_19_tuwaiqjava.Repository;

import com.example.exercise_19_tuwaiqjava.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
}
