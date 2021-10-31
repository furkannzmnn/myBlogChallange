package com.example.myblog.dto.converter;

import com.example.myblog.dto.request.AuthorSaveRequest;
import com.example.myblog.model.Author;
import org.springframework.stereotype.Component;


@Component
public class AuthorSaveRequestConverter {

    public Author authorSaveRequestToAuthor(AuthorSaveRequest request){
        return new Author(request.getAuthorFullName());
    }
    }
