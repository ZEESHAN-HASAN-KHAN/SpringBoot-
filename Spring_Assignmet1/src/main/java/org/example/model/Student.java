package org.example.model;
import java.util.List;

import org.example.model.Course;
import org.springframework.stereotype.Component;

@Component("student")

public class Student {
    private int studentId;
    private String studentName;
    private int studentRoll;
    private List<Course> courseList;

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentRoll() {
        return studentRoll;
    }
    public void setStudentRoll(int studentRoll) {
        this.studentRoll = studentRoll;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRoll=" + studentRoll
                + ", courseList=" + courseList + "]";
    }




}