package com.stackroute.news.repository;

import com.stackroute.news.model.UserNews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NewsRepository extends MongoRepository<UserNews,Integer> {

}

