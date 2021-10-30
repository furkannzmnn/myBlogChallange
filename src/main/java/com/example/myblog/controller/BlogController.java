package com.example.myblog.controller;

import com.example.myblog.core.ApiResponseHandler;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.model.Author;
import com.example.myblog.model.Blog;
import com.example.myblog.service.BlogService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController

@RequestMapping("/api/v1/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @Transactional
    @PostMapping("/blog/content")
    @Operation(description = "CREATE BLOG CONTENT")
    @ApiResponse(
            responseCode = "201",
            description = "Successfully Blog Created",
            content = {@Content(mediaType = "application/json")}
    )
    public ResponseEntity<?> createBlogContent(@RequestBody @Valid BlogSaveRequest blogSaveRequest){
        return ApiResponseHandler.jsonGenerateResponse(
                "blog created",
                HttpStatus.CREATED,
                blogService.createBlogContent(blogSaveRequest)
        );
    }

    @Transactional
    @GetMapping("/list")
    public ResponseEntity<?> listBlogs(){
        return ApiResponseHandler.jsonGenerateResponse(
                "blogs listed",
                HttpStatus.CREATED,
                blogService.getBlogContent()
        );
    }



}
