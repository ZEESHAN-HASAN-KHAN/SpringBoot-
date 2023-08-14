package com.springassignment3.repository;
import com.springassignment3.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByBlogTitle(String blogTitle); //custom method to find the blog with specific title

}

