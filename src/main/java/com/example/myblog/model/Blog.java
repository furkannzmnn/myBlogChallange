package com.example.myblog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public final class Blog extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 2400 , nullable = false)
    private String content;

    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Blog(int id, String content, Author author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public Blog( String content, String videoUrl, Author author) {
        this.content = content;
        this.videoUrl = videoUrl;
        this.author = author;
    }

    public Blog(int id, String content, String videoUrl, Author author) {
        this.id = id;
        this.content = content;
        this.videoUrl = videoUrl;
        this.author = author;
    }

    public Blog(String content) {
        this.content = content;
    }

    public Blog() {

    }

    public Blog(String content, String videoUrl) {
        this.content = content;
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
