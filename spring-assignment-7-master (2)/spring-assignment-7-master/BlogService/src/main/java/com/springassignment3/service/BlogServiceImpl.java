package com.springassignment3.service;

import com.springassignment3.model.Blog;
import com.springassignment3.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;
    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog)  {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog updateBlog(Blog blog, int blogId) {
        Optional<Blog> optUser = blogRepository.findById(blogId);
        if(optUser.isEmpty())
        {
            return null;
        }
        Blog existingUser = optUser.get();
        if(blog.getBlogTitle()!=null){
            existingUser.setBlogTitle(blog.getBlogTitle());
        }
        if(blog.getBlogContent()!=null){
            existingUser.setBlogContent(blog.getBlogContent());
        }
        if(blog.getBlogPublishTime()!=null){
            existingUser.setBlogPublishTime(blog.getBlogPublishTime());
        }
        return blogRepository.save(existingUser);
    }

    @Override
    public boolean deleteBlogById(int blogId) {
        blogRepository.deleteById(blogId);
        return true;
    }

    @Override
    public List<Blog> getBlogByTitle(String blogTitle) {
        return blogRepository.findByBlogTitle(blogTitle); // custom method

    }

}

