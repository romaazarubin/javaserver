package com.example.libr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Book {
    private Long id;
    private String name;
    private String publishing;
    private Date date_of_issue;
    private String fio;
    private Date date_of_delivery;

    protected Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public Date getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(Date date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDate_of_delivery() {
        return date_of_delivery;
    }

    public void setDate_of_delivery(Date date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }

    @Override
    public String toString(){
        return "Book = [id=" +  id + ", name=" + name +", publishing=" + publishing +", date_of_issue=" + date_of_issue +", fio=" + fio +", date_of_delivery=" + date_of_delivery + "]";
    }

}
