package com.gradleexample.repository;

import com.gradleexample.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentDepartment(String department);
}
