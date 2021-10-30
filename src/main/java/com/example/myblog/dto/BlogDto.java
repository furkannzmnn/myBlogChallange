package com.example.myblog.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class BlogDto {

    @NotBlank(message = "content in not be empty")
    @Length(min = 1, max = 2400 , message = "valid length")
    private String content;

    private LocalDateTime publicationDate;

    private String author;

    public BlogDto(String content, LocalDateTime publicationDate, String author) {
        this.content = content;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
