package org.example;

import org.example.config.AppConfig;
import org.example.model.Course;
import org.example.model.Professor;
import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course=context.getBean("course",Course.class);
        Student student=context.getBean("student",Student.class);
        Professor prof=context.getBean("professor",Professor.class);
        System.out.println(student.getStudentName());
        System.out.println(student.getStudentRoll());
        System.out.println(course.getCourseId());
        System.out.println(course.getCourseName());
        System.out.println(prof.getProfName());
    }
}