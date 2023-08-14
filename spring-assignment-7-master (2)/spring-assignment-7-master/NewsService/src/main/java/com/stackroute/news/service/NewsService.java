package com.stackroute.news.service;

import com.stackroute.news.exception.NewsAlreadyExistsException;
import com.stackroute.news.exception.NewsNotFoundException;
import com.stackroute.news.model.UserNews;

import java.util.List;

public interface NewsService {
    UserNews saveNewsDetail(UserNews customer) throws NewsAlreadyExistsException;
    boolean deleteNews(int userId) throws NewsNotFoundException;
    List<UserNews> getAllNewsDetail() throws Exception;
}
