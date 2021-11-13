package com.example.myblog;

import com.example.myblog.dto.converter.BlogSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.BlogDtoConverter;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import com.example.myblog.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class IntegrationTestSupport {

    public final static String BLOG_CONTENT_URL = "/api/v1/blogs/blog/content";

    @Autowired
    public BlogRepository blogRepository;

    @Autowired
    public BlogSaveRequestConverter blogSaveRequestConverter;

    @Autowired
    public BlogDtoConverter blogDtoConverter;

    @Autowired
    public BlogService blogService;

    @Autowired
    public MockMvc mockMvc;

    public final ObjectMapper mapper = new ObjectMapper();

    public Blog generateBlog() {
        return new Blog("content", "embedded-url");
    }

    public Author generateAuthor() {
        return new Author("FURKAN ÖZMEN");
    }

    public BlogSaveRequest generateSaveRequest() {
        return new BlogSaveRequest("content","embedded",generateAuthor());
    }
}
