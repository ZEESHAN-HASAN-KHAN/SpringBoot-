package com.springassignment3.controller;

import com.springassignment3.model.Blog;
import com.springassignment3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
public class BlogController {
    private BlogService blogService;
    private ResponseEntity responseEntity;
    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;

    }
    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.CREATED);
    }
    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs() {
        responseEntity = new ResponseEntity(blogService.getAllBlogs(), HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/blogs/{blogTitle}")
    public ResponseEntity<?> getAllBlogsByTitle(@PathVariable String blogTitle) {
        return new ResponseEntity<>(blogService.getBlogByTitle(blogTitle), HttpStatus.FOUND);
    }
    @DeleteMapping("/blog/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable int blogId){
        return new ResponseEntity<>(blogService.deleteBlogById(blogId), HttpStatus.OK);
    }
    @PutMapping("/blog/{blogId}")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog,@PathVariable int blogId) {
        return new ResponseEntity<>(blogService.updateBlog(blog,blogId), HttpStatus.OK);
    }


}

