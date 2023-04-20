package com.example.dz26.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Client {
    private Long id;
    private String name;
    private String content;
    private String departure_city;
    private String departure_date;
    private String arrival_city;
    private String arrival_date;

    public Client() {
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

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public String getDeparture_city() {

        return departure_city;
    }

    public void setDeparture_city(String departure_city) {

        this.departure_city = departure_city;
    }

    public String getDeparture_date() {

        return departure_date;
    }

    public void setDeparture_date(String departure_date) {

        this.departure_date = departure_date;
    }

    public String getArrival_city() {

        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {

        this.arrival_city = arrival_city;
    }

    public String getArrival_date() {

        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {

        this.arrival_date = arrival_date;
    }

    @Override
    public String toString() {
        return "Client = [id=" + id + ", name=" + name + ", content=" + content + ", departure_city=" + departure_city + ", departure_date=" + departure_date + ", arrival_city=" + arrival_city + ", arrival_date=" + arrival_date + "]";
    }

}
