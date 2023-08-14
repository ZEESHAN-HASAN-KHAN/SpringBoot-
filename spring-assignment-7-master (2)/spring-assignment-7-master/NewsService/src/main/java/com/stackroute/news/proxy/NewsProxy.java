package com.stackroute.news.proxy;


import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name="blog-service",url="blogservice:8082")
public class NewsProxy {
}
