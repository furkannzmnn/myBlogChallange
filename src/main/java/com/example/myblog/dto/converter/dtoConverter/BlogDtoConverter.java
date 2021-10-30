package com.example.myblog.dto.converter.dtoConverter;

import com.example.myblog.dto.BlogDto;
import com.example.myblog.model.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogDtoConverter {

    public BlogDto convertToBlogDto(Blog from){
        return new BlogDto(from.getContent(),
                from.getPublicationDate(),
                from.getAuthor().getAuthorFullName());
    }
}
