package com.gradleexample.models;


import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ALL_STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id", unique = true, nullable = false)
    private int rollNumber;

    //    @Column(name="FNAME")
    private String studentName;

    //    @Column(name="LNAME")
    private String studentDepartment;

    //    @Column(name="DATE")
//    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    public Student() {
    }

    public Student(String studentName, String studentDepartment, LocalDate date) {
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
        this.date = date;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

