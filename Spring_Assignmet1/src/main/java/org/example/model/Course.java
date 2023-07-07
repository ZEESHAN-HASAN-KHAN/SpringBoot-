package org.example.model;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("course")

public class Course {

    private int courseId;
    private String courseName;

    private List<Student> studentCourseList;
    private Professor courseProf;



    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentCourseList() {
        return studentCourseList;
    }
    public void setStudentCourseList(List<Student> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }
    public Professor getCourseProf() {
        return courseProf;
    }
    public void setCourseProf(Professor courseProf) {
        this.courseProf = courseProf;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice="
                + ", studentCourseList=" + studentCourseList + ", courseProf=" + courseProf + "]";
    }




}