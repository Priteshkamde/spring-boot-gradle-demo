package com.gradleexample.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALL_COLLEGES")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id", unique = true, nullable = false)
    private int id;

//    @Column(name="FNAME")
    private String collegeName;

//    @Column(name="LNAME")
    private String collegeAddress;

//    @Column(name="CEMAILID")
    private String collegeEmail;

//    public List<Classroom> classroomList = new ArrayList<>();

    public College() {
    }

    public College(String collegeName, String collegeAddress, String collegeEmail) {
        this.collegeName = collegeName;
        this.collegeAddress = collegeAddress;
        this.collegeEmail = collegeEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }
}
