package com.stackroute.news.service;

import com.stackroute.news.exception.NewsAlreadyExistsException;
import com.stackroute.news.exception.NewsNotFoundException;
import com.stackroute.news.model.News;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.repository.NewsRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    public News newsVar[];

    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public UserNews saveNewsDetail(UserNews news) throws NewsAlreadyExistsException {
        if (newsRepository.findById(news.getUserId()).isPresent()) {
            throw new NewsAlreadyExistsException();
        }
        newsVar = news.getNewsList();
        String url = newsVar[0].getUrl();
        Binary data;
        try {
            data = convertUrlToImg(url);
            ByteArrayInputStream inStreambj = new ByteArrayInputStream(data.getData());
            BufferedImage newImage = ImageIO.read(inStreambj);
            //ImageIO.write(newImage, "jpg", new File("NewsService/src/main/assets/outputImage"+news.getUserId()+".jpg"));
            System.out.println("Image generated from the byte array.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        newsVar[0].setUrlToImage(data);
        return newsRepository.save(news);
    }

    public Binary convertUrlToImg(String url) throws Exception {
        URL imgUrl = new URL(url);
        InputStream is = imgUrl.openStream();
        byte[] img = is.readAllBytes();
        Binary bin = new Binary(img);
        return bin;
    }

    @Override
    public boolean deleteNews(int userId) throws NewsNotFoundException {
        boolean flag = false;
        if(newsRepository.findById(userId).isEmpty())
        {
            throw new NewsNotFoundException();
        }
        else {
            newsRepository.deleteById(userId);
            flag = true;
        }
        return flag;

    }

    @Override
    public List<UserNews> getAllNewsDetail() throws Exception {
        return newsRepository.findAll();
    }


}

