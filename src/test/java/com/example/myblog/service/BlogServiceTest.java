package com.example.myblog.service;

import com.example.myblog.dto.BlogDto;
import com.example.myblog.dto.converter.BlogSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.BlogDtoConverter;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BlogServiceTest {


    private BlogRepository blogRepository;
    private BlogDtoConverter blogDtoConverter;
    private BlogSaveRequestConverter blogSaveRequestConverter;
    private BlogService blogService;

    @BeforeEach
    void setUp() {
        blogRepository = mock(BlogRepository.class);
        blogDtoConverter = mock(BlogDtoConverter.class);
        blogService = new BlogService(blogRepository, blogSaveRequestConverter,blogDtoConverter);
    }

    @Test
    void createBlogContent() {
    }

    @Test
    void getBlogContent() {

        Author author = new Author("FURKAN ÖZMEN");
        Blog blog = new Blog(1,"This is a blog content" , author);
        BlogDto blogDto = new BlogDto(blog.getContent() , blog.getPublicationDate() ,blog.getAuthor().getAuthorFullName());

        Mockito.when(blogRepository.findAll()).thenReturn(List.of(blog));
        Mockito.when(blogDtoConverter.convertToBlogDto(blog)).thenReturn(blogDto);

        List<Blog> blogs = blogRepository.findAll();
        assertEquals(blogs,List.of(blog));
    }
}