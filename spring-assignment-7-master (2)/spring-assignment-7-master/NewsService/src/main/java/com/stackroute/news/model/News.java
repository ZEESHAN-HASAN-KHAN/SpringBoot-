package com.stackroute.news.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;

import java.time.LocalDateTime;
@NoArgsConstructor
public class News {
    private int newsId;
    private String title;
    private String author;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime publishedAt;
    private String content;
    private String url;
    private Binary urlToImage;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Binary getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(Binary urlToImage) {
        this.urlToImage = urlToImage;
    }

    public News(int newsId, String title, String author, String description, LocalDateTime publishedAt, String content, String url, Binary urlToImage) {
        this.newsId = newsId;
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                '}';
    }
}
