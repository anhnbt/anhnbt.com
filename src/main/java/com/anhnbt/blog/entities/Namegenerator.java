package com.anhnbt.blog.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "namegenerator")
public class Namegenerator {
    @EmbeddedId
    private NamegeneratorId id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name_generator", nullable = false)
    private String nameGenerator;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "count_like", nullable = false)
    private Integer countLike;

    @Column(name = "count_dislike", nullable = false)
    private Integer countDislike;

    @Column(name = "views", nullable = false)
    private Integer views;

    public NamegeneratorId getId() {
        return id;
    }

    public void setId(NamegeneratorId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameGenerator() {
        return nameGenerator;
    }

    public void setNameGenerator(String nameGenerator) {
        this.nameGenerator = nameGenerator;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCountLike() {
        return countLike;
    }

    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }

    public Integer getCountDislike() {
        return countDislike;
    }

    public void setCountDislike(Integer countDislike) {
        this.countDislike = countDislike;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

}