package com.example.exercise_19_tuwaiqjava.Service;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiException;
import com.example.exercise_19_tuwaiqjava.Model.Course;
import com.example.exercise_19_tuwaiqjava.Model.Student;
import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import com.example.exercise_19_tuwaiqjava.Repository.CourseRepository;
import com.example.exercise_19_tuwaiqjava.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse==null)
            throw new ApiException("course not found");
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null)
            throw new ApiException("Course not found");
        courseRepository.delete(course);
    }

    public void assignCourse(Integer id, Integer teacher_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(id);
        if (teacher==null||course==null)
            throw new ApiException("course or teacher not found");
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getTeacherName(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null)
            throw new ApiException("course not found");
        return course.getTeacher().getName();
    }

    public Set<Student> getAllStudents(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null)
            throw new ApiException("course not found ");

        return course.getStudent();
    }
}
