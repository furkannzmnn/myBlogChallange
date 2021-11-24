package com.example.myblog.controller;

import com.example.myblog.dto.AuthorDto;
import com.example.myblog.dto.ResponseApi;
import com.example.myblog.dto.request.AuthorSaveRequest;
import com.example.myblog.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseApi> createAuthor(@RequestBody @Valid AuthorSaveRequest authorSaveRequest){
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("created author")
                        .StatusCode(201)
                        .HttpStatus(HttpStatus.CREATED)
                        .Data(Map.of("blogs", authorService.createAuthor(authorSaveRequest)))
                        .build()
        );
    }

    @Transactional
    @GetMapping("/get/authors")
    public ResponseEntity<?> listAuthor(){
        return ResponseEntity.ok(
                new ResponseApi.ResponseBuilder()
                        .TimeStamp(now())
                        .Message("listed blog")
                        .StatusCode(201)
                        .HttpStatus(HttpStatus.CREATED)
                        .Data(Map.of("blogs", authorService.authorList()))
                        .build()
        );
    }
}
