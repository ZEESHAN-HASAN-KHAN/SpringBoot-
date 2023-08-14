package com.stackroute.news.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@NoArgsConstructor
@Document
public class UserNews {
    @Id
    private int userId;
    private News[] newsList;
    public UserNews(int userId, News[] newsList) {
        this.userId = userId;
        this.newsList = newsList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public News[] getNewsList() {
        return newsList;
    }

    public void setNewsList(News[] newsList) {
        this.newsList = newsList;
    }

    @Override
    public String toString() {
        return "UserNews{" +
                "userId=" + userId +
                ", newsList=" + Arrays.toString(newsList) +
                '}';
    }
}
