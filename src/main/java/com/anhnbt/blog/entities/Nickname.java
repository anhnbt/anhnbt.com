package com.anhnbt.blog.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "nickname")
public class Nickname {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "count_like")
    private Integer countLike;

    @Column(name = "views")
    private Integer views;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Nickname nickname = (Nickname) o;
        return id != null && Objects.equals(id, nickname.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}