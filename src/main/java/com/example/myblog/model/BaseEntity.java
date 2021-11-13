package com.example.myblog.model;

import java.time.LocalDateTime;

public class BaseEntity {

    private final LocalDateTime publicationDate = LocalDateTime.now();

    private LocalDateTime updateAt = LocalDateTime.now();

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        updateAt = LocalDateTime.now();
        this.updateAt = updateAt;
    }
}
