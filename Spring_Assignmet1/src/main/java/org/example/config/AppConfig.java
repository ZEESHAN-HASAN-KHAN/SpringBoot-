package org.example.config;
import java.util.ArrayList;
import java.util.List;

import org.example.model.Course;
import org.example.model.Professor;
import org.example.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {

        Student stu=new Student();
        stu.setStudentName("Zeeshan");
        stu.setStudentId(1906525);
        stu.setStudentRoll(1906525);

        Course cs1=new Course();
        Course cs2=new Course();

        Professor pf=new Professor();
        pf.setProfId(312);
        pf.setProfName("Singh");
        pf.setProfCourse(cs1);

        cs1.setCourseId(121);
        cs1.setCourseName("Java");
        cs1.setCourseProf(pf);
        List<Course> li=new ArrayList<Course>();

        li.add(cs2);
        li.add(cs1);

        stu.setCourseList(li);

        return stu;
    }

    @Bean
    public Course course() {
//        Course cs1=new Course();
//        Professor pf=new Professor();
//        pf.setProfId(312);
//        pf.setProfName("Singh");
//        pf.setProfCourse(cs1);
//
//        cs1.setCourseId(121);
//        cs1.setCourseName("Java");
//        cs1.setCourseProf(pf);
//        return new Course();
        Course cs=new Course();
        cs.setCourseId(121);
        cs.setCourseName("Java");

        Professor pf=new Professor();
        pf.setProfId(312);
        pf.setProfName("Singh");
        pf.setProfCourse(cs);

        cs.setCourseProf(pf);

        return cs;
    }

    @Bean
    public Professor professor() {
        Professor pf=new Professor();
        pf.setProfId(312);
        pf.setProfName("Singh");

        Course cs=new Course();
        cs.setCourseId(121);
        cs.setCourseName("Java");
        cs.setCourseProf(pf);

        pf.setProfCourse(cs);

        return pf;
    }

}