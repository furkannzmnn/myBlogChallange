package com.example.myblog.service;
import com.example.myblog.core.Constant;
import com.example.myblog.dto.BlogDto;
import com.example.myblog.dto.converter.BlogSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.BlogDtoConverter;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.exception.BlogNotFoundException;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogSaveRequestConverter blogSaveRequestConverter;
    private final BlogDtoConverter blogDtoConverter;

    public BlogService(BlogRepository blogRepository, BlogSaveRequestConverter blogSaveRequestConverter, BlogDtoConverter blogDtoConverter) {
        this.blogRepository = blogRepository;
        this.blogSaveRequestConverter = blogSaveRequestConverter;
        this.blogDtoConverter = blogDtoConverter;
    }

    public BlogDto createBlogContent(BlogSaveRequest blogSaveRequest){

        Blog blog = blogSaveRequestConverter.blogSaveRequestToBlog(blogSaveRequest);

        return blogDtoConverter.convertToBlogDto(
                this.blogRepository.save(blog)
        );
    }

    public List<BlogDto> getBlogContent()   {
        return this.blogRepository.findAll()
                .stream()
                .map(blogDtoConverter::convertToBlogDto)
                .collect(Collectors.toList());
    }

    public BlogDto getByIdBlog(int id){
        return blogDtoConverter.convertToBlogDto(findById(id));
    }

    private Blog findById(int id){
        return blogRepository.findById(id)
                .orElseThrow(
                        () -> new BlogNotFoundException(Constant.BLOG_NOT_FOUND)
                );
    }
}
