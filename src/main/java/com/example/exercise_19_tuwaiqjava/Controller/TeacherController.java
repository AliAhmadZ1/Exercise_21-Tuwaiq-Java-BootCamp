package com.example.exercise_19_tuwaiqjava.Controller;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiResponse;
import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import com.example.exercise_19_tuwaiqjava.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    // dependency injection
    private final TeacherService teacherService;

    // Read
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    // Create
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher is added"));
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher is updated"));
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher is deleted"));
    }

    // get teacher details endpoint
    @GetMapping("/get-teacher-details/{id}")
    public ResponseEntity teacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.teacherDetails(id));
    }

}
