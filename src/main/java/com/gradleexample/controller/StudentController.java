package com.gradleexample.controller;

import com.gradleexample.models.Student;
import com.gradleexample.repository.StudentRepository;
import org.springframework.data.repository.query.Param;
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

    ////////////////////////  GET   /////////////////////////

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

    @GetMapping("/students")
    public ResponseEntity<Student> getbyStudentName(@RequestParam(value = "name", defaultValue = "Joey") String name){
        Optional<Student> student = this.studentRepository.findByStudentNameEqualsIgnoreCase(name);

        if (student.isPresent()){
            return new ResponseEntity<Student>(student.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    ////////////////////////  GET  & FILTER ///////////////////

    @GetMapping("/dept/{department}")
    public List<Student> getAllDepartments(@PathVariable String department){
        List<Student> studentInDepartments = this.studentRepository.findByStudentDepartment(department);
        return studentInDepartments;
    }

    @GetMapping("/min/marks/{marks}")
    public List<Student> getByMinMarks(@PathVariable int marks){
        List<Student> studentsByMinMarks = this.studentRepository.findByMarksLessThan(marks);
        return studentsByMinMarks;
    }

    @GetMapping("/max/marks/{marks}")
    public List<Student> getByMaxMarks(@PathVariable int marks){
        List<Student> studentsByMaxMarks = this.studentRepository.findByMarksGreaterThan(marks);
        return studentsByMaxMarks;
    }

    ////////////////////////  POST   /////////////////////////

    @PostMapping
    public String studentUpdate(@RequestBody Student student){
        // save acts as UPSERT
        this.studentRepository.save(student);
        return "Added Student with id = " + student.getRollNumber();
    }

    ////////////////////////  DELETE   /////////////////////////

    @DeleteMapping("/student/{id}")
    public String studentDelete(@PathVariable("id") int id){
        this.studentRepository.deleteById(id);
        return "Deleted student with id =  " + id;
    }

}
