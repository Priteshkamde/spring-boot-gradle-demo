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
                LocalDate.of(2020, Month.AUGUST, 24),
                90
                );

        Student s2 = new Student(
                "Joey",
                "arts",
                LocalDate.of(2020, Month.AUGUST, 20),
                95
                );

        Student s3 = new Student(
                "Ross",
                "history",
                LocalDate.of(2020, Month.AUGUST, 20),
                75
        );

        Student s4 = new Student(
                "Monica",
                "cooking",
                LocalDate.of(2020, Month.AUGUST, 20),
                80
        );

        Student s5 = new Student(
                "Rachel",
                "cooking",
                LocalDate.of(2020, Month.AUGUST, 20),
                60
        );

        Student s6 = new Student(
                "Phoebe",
                "arts",
                LocalDate.of(2020, Month.AUGUST, 20),
                85
        );

        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5,s6);
        studentRepository.saveAll(list);
    }
}
