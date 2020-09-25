package com.gradleexample;

import com.gradleexample.models.College;
import com.gradleexample.repository.CollegeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    CollegeRepository collegeRepository;
    public DBSeeder(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        collegeRepository.deleteAll();

        College c1 = new College("Physics School", "Bombay","physics@gmail.com");
        College c2 = new College("Design School", "Delhi","design@gmail.com");
        College c3 = new College("Art School", "Manchester","art@gmail.com");

        List<College> list = Arrays.asList(c1,c2,c3);
        collegeRepository.saveAll(list);
    }
}
