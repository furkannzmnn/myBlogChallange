package com.example.myblog.service;
import com.example.myblog.dto.Constant;
import com.example.myblog.dto.BlogDto;
import com.example.myblog.dto.converter.BlogSaveRequestConverter;
import com.example.myblog.dto.converter.dtoConverter.BlogDtoConverter;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.dto.request.BlogUpdateRequest;
import com.example.myblog.exception.BlogNotFoundException;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.repository.BlogRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService {


    private final BlogRepository blogRepository;
    private final BlogSaveRequestConverter blogSaveRequestConverter;
    private final BlogDtoConverter blogDtoConverter;
    private final AuthorService authorService;


    public BlogService(BlogRepository blogRepository, BlogSaveRequestConverter blogSaveRequestConverter, BlogDtoConverter blogDtoConverter, AuthorService authorService) {
        this.blogRepository = blogRepository;
        this.blogSaveRequestConverter = blogSaveRequestConverter;
        this.blogDtoConverter = blogDtoConverter;
        this.authorService = authorService;
    }

    public BlogDto createBlogContent(BlogSaveRequest blogSaveRequest){

        Blog blog = blogSaveRequestConverter.blogSaveRequestToBlog(blogSaveRequest);

        return blogDtoConverter.convertToBlogDto(
                this.blogRepository.save(blog)
        );
    }

    public List<BlogDto> getBlogContent(int limit)   {
        return this.blogRepository.findAll(Pageable.ofSize(limit))
                .stream()
                .map(blogDtoConverter::convertToBlogDto)
                .collect(Collectors.toList());
    }

    public BlogDto getByIdBlog(int id){
        return blogDtoConverter.convertToBlogDto(findById(id));
    }

    protected Blog findById(int id){
        return blogRepository.findById(id)
                .orElseThrow(
                        () -> new BlogNotFoundException(Constant.BLOG_NOT_FOUND)
                );
    }

    public BlogDto updateBlogContent(int id , BlogUpdateRequest blogUpdateRequest, int authorId){
        Optional<Blog> blogOptional = blogRepository.findById(id);
        Author author = authorService.findById(authorId);

        blogOptional.ifPresent(blog -> {
            blog.setContent(blogUpdateRequest.getContent());
            blog.setVideoUrl(blogUpdateRequest.getVideoUrl());
            blog.setUpdateAt(blogUpdateRequest.getUpdateAt());
            author.setLastModifierId(blog.getId());

            blogRepository.save(blog);
        });



        return blogOptional.map(blogDtoConverter::convertToBlogDto).orElse(new BlogDto());
    }

    public String deleteByBlogId(int id){
        Optional<Blog> blogOptional = blogRepository.findById(id);
        blogOptional.ifPresent(blog -> {
            blogRepository.deleteById(id);
        });
         blogOptional.orElseThrow(
                ()-> new BlogNotFoundException(Constant.BLOG_NOT_FOUND)
        );

         return Constant.DELETE_OBJECT.toString();

    }


}
