package com.example.myblog.exception;

import com.example.myblog.dto.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(Constant message) {
        super(String.valueOf(message));
    }
}
