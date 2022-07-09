package com.anhnbt.blog.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NamegeneratorId implements Serializable {
    private static final long serialVersionUID = -8700038089047976607L;
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "slug", nullable = false)
    private String slug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NamegeneratorId entity = (NamegeneratorId) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.slug, entity.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slug);
    }

}