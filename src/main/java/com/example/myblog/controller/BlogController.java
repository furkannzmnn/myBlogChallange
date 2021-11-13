package com.example.myblog.controller;

import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.dto.*;
import com.example.myblog.dto.request.BlogUpdateRequest;
import com.example.myblog.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Map;

import static java.time.LocalDateTime.now;


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
    public ResponseEntity<ResponseApi> createBlogContent(@RequestBody @Valid BlogSaveRequest blogSaveRequest) {
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("created blog")
                        .StatusCode(201)
                        .HttpStatus(HttpStatus.CREATED)
                        .Data(Map.of("blogs", blogService.createBlogContent(blogSaveRequest)))
                        .build()
        );
    }

    @Transactional
    @GetMapping("/list/limit/{limit}")
    public ResponseEntity<ResponseApi> listBlogs(@PathVariable int limit) {
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("listed contents")
                        .StatusCode(200)
                        .HttpStatus(HttpStatus.OK)
                        .Data(Map.of("blogs", blogService.getBlogContent(limit)))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApi> findById(@PathVariable int id){
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("listed contents")
                        .StatusCode(200)
                        .HttpStatus(HttpStatus.OK)
                        .Data(Map.of("blogs", blogService.getByIdBlog(id)))
                        .build()
        );
    }

    @DeleteMapping("delete/{id}")
    public String deleteByBlogId(@PathVariable int id){
        return blogService.deleteByBlogId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseApi> findById(@PathVariable int id , @Valid @RequestBody BlogUpdateRequest blogUpdateRequest){
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("update successfully")
                        .StatusCode(204)
                        .HttpStatus(HttpStatus.OK)
                        .Data(Map.of("blogs", blogService.updateBlogContent(id,blogUpdateRequest)))
                        .build()
        );
    }



}
