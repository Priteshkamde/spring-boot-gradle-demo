package com.gradleexample.controller;

import com.gradleexample.models.College;
import com.gradleexample.repository.CollegeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    public CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @GetMapping("/all")
    public List<College> getAllProducts(){
        List<College> collegeList = this.collegeRepository.findAll();
        return collegeList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getByID(@PathVariable int id){
        Optional<College> college = this.collegeRepository.findById(id);

        if (college.isPresent()){
            return new ResponseEntity<College>(college.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/address/{location}")
    public ResponseEntity<College> getByAddress(@PathVariable String location){
        Optional<College> collegeByAddress = this.collegeRepository.findByCollegeAddress(location);

        if (collegeByAddress.isPresent()){
            return new ResponseEntity<College>(collegeByAddress.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
