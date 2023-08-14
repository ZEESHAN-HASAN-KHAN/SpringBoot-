package com.springassignment3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    private int blogId;
    private String blogTitle;
    private String blogContent;
    private LocalDate blogPublishTime;

    public Blog() {

    }

    @Override
    public String toString() {
        return "Blog{" +
                "BlogId=" + blogId +
                ", BlogTitle='" + blogTitle + '\'' +
                ", BlogContent='" + blogContent + '\'' +
                ", BlogPublishTime='" + blogPublishTime + '\'' +
                '}';
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public LocalDate getBlogPublishTime() {
        return LocalDate.now();
    }

    public void setBlogPublishTime(LocalDate blogPublishTime) {
        this.blogPublishTime = blogPublishTime;
    }
    public Blog(int blogId, String blogTitle, String blogContent, LocalDate blogPublishTime) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogPublishTime = blogPublishTime;
    }

}
