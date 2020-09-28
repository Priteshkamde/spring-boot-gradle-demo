package com.gradleexample;

import com.gradleexample.models.Student;
import com.gradleexample.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    StudentRepository studentRepository;

    public DBSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        studentRepository.deleteAll();

        Student s1 = new Student(
                "Chandler",
                "physics",
                LocalDate.of(2020, Month.AUGUST, 24)
                );

        Student s2 = new Student(
                "Joey",
                "arts",
                LocalDate.of(2020, Month.AUGUST, 20)
                );

        List<Student> list = Arrays.asList(s1,s2);
        studentRepository.saveAll(list);
    }
}
