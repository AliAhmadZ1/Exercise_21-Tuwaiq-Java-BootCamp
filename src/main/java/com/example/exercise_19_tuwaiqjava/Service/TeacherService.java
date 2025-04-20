package com.example.exercise_19_tuwaiqjava.Service;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiException;
import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import com.example.exercise_19_tuwaiqjava.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    // dependency injection
    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers(){
        if (teacherRepository.findAll().isEmpty())
            throw new ApiException("there are no teachers");
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        // to make email unique in system
        Teacher teacherEmailExist = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if (teacherEmailExist!=null) // if true throw ApiException
            throw new ApiException("email is already exist");
        // add teacher direct
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher teacherEmailExist = teacherRepository.findTeacherByEmail(teacher.getEmail());
        // to get old one to update
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher==null)
            throw new ApiException("teacher not found");
        //check for unique email and ignore current teacher id
        if (teacherEmailExist!=null&&teacherEmailExist.getId()!= oldTeacher.getId())
            throw new ApiException("email is already used");
        // set new values
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        //check if exist
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null) // not found
            throw new ApiException("teacher not found");
        teacherRepository.delete(teacher);
    }

    // endpoint to get all teacher details in one object
    public Teacher teacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null)
            throw new ApiException("teacher not found");
        return teacher;
    }

}
