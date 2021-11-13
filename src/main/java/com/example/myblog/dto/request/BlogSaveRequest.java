package com.example.myblog.dto.request;

import com.example.myblog.model.Author;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BlogSaveRequest {
    @NotBlank(message = "content is not be empty")
    private String content;

    private final String videoUrl;

    @NotNull(message = "author is not be null")
    private final Author author;

    public BlogSaveRequest(String content, String videoUrl, Author author) {
        this.content = content;
        this.videoUrl = videoUrl;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
