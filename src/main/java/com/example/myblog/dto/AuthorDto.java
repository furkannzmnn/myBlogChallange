package com.example.myblog.dto;

public class AuthorDto {

    private int id;

    private String authorFullName;

    public AuthorDto(int id, String authorFullName) {
        this.id = id;
        this.authorFullName = authorFullName;
    }

    public int getId() {
        return id;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }
}
