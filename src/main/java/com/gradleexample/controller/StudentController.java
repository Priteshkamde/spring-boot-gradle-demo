package com.gradleexample.controller;

import com.gradleexample.models.Student;
import com.gradleexample.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/college")
public class StudentController {

    public StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        List<Student> studentList = this.studentRepository.findAll();
        return studentList;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getbyRollNumber(@PathVariable int id){
        Optional<Student> student = this.studentRepository.findById(id);

        if (student.isPresent()){
            return new ResponseEntity<Student>(student.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dept/{department}")
    public List<Student> getAllDepartments(@PathVariable String department){
        List<Student> studentInDepartments = this.studentRepository.findByStudentDepartment(department);
        return studentInDepartments;
    }

    @PostMapping
    public String studentUpdate(@RequestBody Student student){
        // save acts as UPSERT
        this.studentRepository.save(student);
        return "Added Student with id = " + student.getRollNumber();
    }

    @DeleteMapping("/student/{id}")
    public String studentDelete(@PathVariable("id") int id){
        this.studentRepository.deleteById(id);
        return "Deleted student with id =  " + id;
    }



}
