package com.example.myblog.controller;

import com.example.myblog.core.ApiResponseHandler;
import com.example.myblog.dto.request.AuthorSaveRequest;
import com.example.myblog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Transactional
    @PostMapping("/")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorSaveRequest authorSaveRequest){
        return ApiResponseHandler.jsonGenerateResponse(
                "created Author",
                HttpStatus.CREATED,
                authorService.createAuthor(authorSaveRequest)
        );
    }

    @Transactional
    @GetMapping("/get/authors")
    public ResponseEntity<?> listAuthor(){
        return ApiResponseHandler.jsonGenerateResponse(
                "listed Authors",
                HttpStatus.OK,
                authorService.authorList()
        );
    }
}
