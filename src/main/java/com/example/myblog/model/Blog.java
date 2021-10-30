package com.example.myblog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 2400 , nullable = false)
    private String content;

    private final LocalDateTime publicationDate = LocalDateTime.now();

    private final LocalDateTime updateAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Blog(int id, String content, Author author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public Blog(String content, Author author) {
        this.content = content;
        this.author = author;
    }

    public Blog(String content) {
        this.content = content;
    }

    public Blog() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
