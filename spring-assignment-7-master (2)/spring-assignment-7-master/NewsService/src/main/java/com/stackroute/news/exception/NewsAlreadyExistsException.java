package com.stackroute.news.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "User News already exists")
public class NewsAlreadyExistsException extends Exception {
}
