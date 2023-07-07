package org.example.model;
import org.example.model.Course;
import org.springframework.stereotype.Component;

@Component("professor")

public class Professor {

    private int profId;
    private String profName;

    private Course profCourse;

    public int getProfId() {
        return profId;
    }
    public void setProfId(int profId) {
        this.profId = profId;
    }
    public String getProfName() {
        return profName;
    }
    public void setProfName(String profName) {
        this.profName = profName;
    }
    public Course getProfCourse() {
        return profCourse;
    }
    public void setProfCourse(Course profCourse) {
        this.profCourse = profCourse;
    }
    @Override
    public String toString() {
        return "Professor [profId=" + profId + ", profName=" + profName + ", profCourse=" + profCourse + "]";
    }



}