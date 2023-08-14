package com.stackroute.news.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND , reason = "User with specified id is not found")
public class NewsNotFoundException extends Exception{
}
