package com.gradleexample.models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ALL_STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SID", unique = true, nullable = false)
    private int rollNumber;

    @Column(name="SNAME")
    private String studentName;

    @Column(name="DEPT")
    private String studentDepartment;

    @Column(name="JOIN_DATE")
    private LocalDate date;

    @Column(name = "MARKS")
    private int marks;

    public Student() {
    }

    public Student(String studentName, String studentDepartment, LocalDate date, int marks) {
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
        this.date = date;
        this.marks = marks;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

