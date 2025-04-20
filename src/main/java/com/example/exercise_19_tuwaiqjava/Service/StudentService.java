package com.example.exercise_19_tuwaiqjava.Service;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiException;
import com.example.exercise_19_tuwaiqjava.Model.Course;
import com.example.exercise_19_tuwaiqjava.Model.Student;
import com.example.exercise_19_tuwaiqjava.Repository.CourseRepository;
import com.example.exercise_19_tuwaiqjava.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findStudentById(id);
        if (oldStudent==null)
            throw new ApiException("student Not found");

        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setName(student.getName());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (student==null)
            throw new ApiException("student not found");

        studentRepository.delete(student);
    }

    public void assignCourse(Integer id, Integer course_id){
        Student student = studentRepository.findStudentById(id);
        Course course = courseRepository.findCourseById(course_id);
        if (student==null)
            throw new ApiException("student not found");
        if (course==null)
            throw new ApiException("course not found");

        student.getCourses().add(course);
        course.getStudent().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer id, String major){
        Student student = studentRepository.findStudentById(id);
        if (student==null)
            throw new ApiException("student not found");

        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }

}
