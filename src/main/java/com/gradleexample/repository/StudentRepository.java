package com.gradleexample.repository;

import com.gradleexample.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentDepartment(String department);

    List<Student> findByMarksLessThan(int marks);

    List<Student> findByMarksGreaterThan(int marks);

    Optional<Student> findByStudentNameEqualsIgnoreCase(String name);
}
