package com.stackroute.news.controller;

import com.stackroute.news.exception.NewsAlreadyExistsException;
import com.stackroute.news.exception.NewsNotFoundException;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v3/")
public class NewsController {
    private ResponseEntity responseEntity;
    private NewsService newsService;


    @Autowired
    public NewsController(final NewsService newsService)
    {
        this.newsService = newsService;
    }

    @PostMapping("news")
    public ResponseEntity<?> saveNews(@RequestBody UserNews news) throws NewsAlreadyExistsException {
        try {
            newsService.saveNewsDetail(news);
            responseEntity = new ResponseEntity(news , HttpStatus.CREATED);
        } catch (NewsAlreadyExistsException e) {
            throw new NewsAlreadyExistsException();

        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @DeleteMapping("news/{userId}")
    public ResponseEntity<?> deleteNews(@PathVariable("userId") int userId) throws NewsNotFoundException {

        try {
            newsService.deleteNews(userId);
            responseEntity = new ResponseEntity( HttpStatus.OK);
        } catch (NewsNotFoundException e) {
            throw new NewsNotFoundException();
        }
        catch (Exception exception){
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("newss")
    public ResponseEntity<?> getAllUserNews(){
        try{
            responseEntity = new ResponseEntity(newsService.getAllNewsDetail(), HttpStatus.OK);
        }catch (Exception exception){
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

}
