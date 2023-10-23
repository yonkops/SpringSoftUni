package com.lcsoft.pathfinder.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public Picture() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
/*title - Accepts String values
url - Accepts very long String values
author - Accepts User Entities as values
route - Accepts Route Entities as values*/