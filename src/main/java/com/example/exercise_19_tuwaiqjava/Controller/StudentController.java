package com.example.exercise_19_tuwaiqjava.Controller;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiResponse;
import com.example.exercise_19_tuwaiqjava.Model.Student;
import com.example.exercise_19_tuwaiqjava.Service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody@Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("is deleted"));
    }

    @PostMapping("/add-course/{id}/course/{course_id}")
    public ResponseEntity assignCourse(@PathVariable Integer id, @PathVariable Integer course_id){
        studentService.assignCourse(id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course is assigned"));
    }
}
