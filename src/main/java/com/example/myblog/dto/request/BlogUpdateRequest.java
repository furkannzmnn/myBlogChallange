package com.example.myblog.dto.request;

import com.example.myblog.model.Author;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class BlogUpdateRequest {

    private String content;
    private final LocalDateTime updateAt = LocalDateTime.now();
    private String videoUrl;


    public String getContent() {
        return content;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
