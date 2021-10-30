package com.example.myblog.dto.converter.dtoConverter;

import com.example.myblog.dto.AuthorDto;
import com.example.myblog.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoConverter {

    public AuthorDto convertToAuthorDto(Author from){
        return new AuthorDto(
                from.getId(),
                from.getAuthorFullName()
        );
    }
}
