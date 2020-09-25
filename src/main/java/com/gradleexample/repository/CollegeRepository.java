package com.gradleexample.repository;

import com.gradleexample.models.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
    Optional<College> findByCollegeAddress(String location);
}
