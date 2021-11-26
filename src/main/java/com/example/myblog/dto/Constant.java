package com.example.myblog.dto;

public enum Constant {
    // FOUND MESSAGE
    BLOG_NOT_FOUND("BLOG NOT FOUND"),
    AUTHOR_NOT_FOUND("AUTHOR NOT FOUND"),

    // CREATED MESSAGE
    BLOG_IS_NOT_CREATED("BLOG IS NOT CREATED"),
    AUTHOR_IS_NOT_CREATED("AUTHOR IS NOT CREATED"),

    //DELETE MESSAGE
    DELETE_OBJECT("DELETED OBJECT");


    private final String code;

    Constant(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
