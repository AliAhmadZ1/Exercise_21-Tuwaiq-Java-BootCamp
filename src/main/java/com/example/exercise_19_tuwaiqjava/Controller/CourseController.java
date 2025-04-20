package com.example.exercise_19_tuwaiqjava.Controller;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiResponse;
import com.example.exercise_19_tuwaiqjava.Model.Course;
import com.example.exercise_19_tuwaiqjava.Service.CourseService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody@Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("new course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody@Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course is deleted"));
    }

    @PutMapping("/assign/{id}/teacher/{teacher_id}")
    public ResponseEntity assignCourse(@PathVariable Integer id, @PathVariable Integer teacher_id){
        courseService.assignCourse(id, teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("course is assigned to the teacher"));
    }

    @GetMapping("/get-teacher-name/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }


}
