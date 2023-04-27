package com.example.dz26.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutoBlog {
    private Long id;
    private String date;
    private String author;
    private String text;

    public AutoBlog() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    @Override
    public String toString() {
        return "AutoBlog = [id=" + id + ", date=" + date + ", author=" + author + ", text=" + text + "]";
    }

}
