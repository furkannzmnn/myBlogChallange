package com.example.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String authorFullName;

    @JsonIgnore
    @OneToMany(mappedBy = "author" , fetch = FetchType.LAZY)
    private Set<Blog> blog = new HashSet<>();

    public Author(int id, String authorFullName, Set<Blog> blog) {
        this.id = id;
        this.authorFullName = authorFullName;
        this.blog = blog;
    }

    public Author(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public Author() {}

    public Author(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public Set<Blog> getBlog() {
        return blog;
    }

    public void setBlog(Set<Blog> blog) {
        this.blog = blog;
    }
}
