package com.lcsoft.pathfinder.model.entity;

import com.lcsoft.pathfinder.model.enums.UserLevel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private UserLevel level;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @ManyToOne
    private User author;
    private String videoUrl;
    @ManyToMany
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
/*gpx coordinates - Accepts very long text values
level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
name - Accepts String values
author - Accepts User Entities as values
video url – Accepts the ids of youtube videos as values*/