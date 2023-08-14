package com.springassignment3.service;

import com.springassignment3.model.Blog;

import java.util.List;

public interface BlogService {
    //method to be implemented in services are declared/initialised here
    Blog saveBlog(Blog blog);
    List<Blog> getAllBlogs();
    Blog updateBlog(Blog blog, int blogId );
    boolean deleteBlogById(int blogId);
    List<Blog> getBlogByTitle(String blogTitle);

}
