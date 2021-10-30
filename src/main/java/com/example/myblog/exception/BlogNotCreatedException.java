package com.example.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BlogNotCreatedException extends RuntimeException{
    public BlogNotCreatedException(String message , String authorName) {
        super(message + " " +  authorName);
    }
}
