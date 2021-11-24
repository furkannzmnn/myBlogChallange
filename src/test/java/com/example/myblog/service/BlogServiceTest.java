package com.example.myblog.service;

import com.example.myblog.dto.BlogDto;
import com.example.myblog.dto.converter.BlogSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.BlogDtoConverter;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.exception.BlogNotFoundException;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BlogServiceTest {


    private BlogRepository blogRepository;
    private BlogDtoConverter blogDtoConverter;
    private BlogSaveRequestConverter blogSaveRequestConverter;
    private BlogService blogService;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        blogRepository = mock(BlogRepository.class);
        blogDtoConverter = mock(BlogDtoConverter.class);
        blogSaveRequestConverter = mock(BlogSaveRequestConverter.class);
        authorService = mock(AuthorService.class);
        blogService = new BlogService(blogRepository, blogSaveRequestConverter,blogDtoConverter, authorService);
    }

    @Test
    void findByIdBlog(){

        Author author = new Author("yazar");
        Blog blog = new Blog(2,"content","", author);
        BlogDto blogDto = new BlogDto(blog.getId(),"content" , LocalDateTime.now(), "Author full name");

        when(blogDtoConverter.convertToBlogDto(blog)).thenReturn(blogDto);
        when(blogDtoConverter.convertToBlogDto(blogService.findById(blog.getId()))).thenThrow(BlogNotFoundException.class);

        verify(blogService).getByIdBlog(blogDto.getId());

        BlogDto result = blogService.getByIdBlog(blogDto.getId());
        assertThrows(RuntimeException.class, () -> blogService.getByIdBlog(blog.getId()));
        assertEquals(result,blogDto);


    }


    @Test
    void getBlogContent() {

        Author author = new Author("FURKAN ÖZMEN");
        Blog blog = new Blog(1,"This is a blog content" , author);
        BlogDto blogDto = new BlogDto(blog.getContent() , blog.getPublicationDate() ,blog.getAuthor().getAuthorFullName());

        Mockito.when(blogRepository.findAll()).thenReturn(List.of(blog));
        Mockito.when(blogDtoConverter.convertToBlogDto(blog)).thenReturn(blogDto);

        List<Blog> result = blogRepository.findAll();
        assertEquals(result,List.of(blog));
    }

    @Test()
    void createBlogContent() {

        Author author = new Author("FURKAN ÖZMEN");
        Blog blog = new Blog("content" , "www.youtube.com" , author );
        BlogSaveRequest blogSaveRequest = new BlogSaveRequest(blog.getContent() ,blog.getVideoUrl());
        BlogDto expected = new BlogDto(blog.getContent() , blog.getPublicationDate() ,blog.getAuthor().getAuthorFullName());

        when(blogRepository.save(blogSaveRequestConverter.blogSaveRequestToBlog(blogSaveRequest))).thenReturn(blog);
        when(blogDtoConverter.convertToBlogDto(blog)).thenReturn(expected);

        BlogDto result = blogService.createBlogContent(blogSaveRequest);

        assertEquals(result,expected);


    }
}