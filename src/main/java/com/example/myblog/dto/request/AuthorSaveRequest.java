package com.example.myblog.dto.request;

import javax.validation.constraints.NotBlank;

public class AuthorSaveRequest {

    @NotBlank(message = "name is not be empty")
    private String authorFullName;

    public String getAuthorFullName() {
        return authorFullName;
    }

    public AuthorSaveRequest(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public AuthorSaveRequest() {
    }
}
