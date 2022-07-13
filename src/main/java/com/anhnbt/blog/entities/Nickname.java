package com.anhnbt.blog.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nickname")
public class Nickname implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "nickname")
    @NotNull
    private String nickname;

    @Column(name = "count_like")
    private Integer countLike;

    @Column(name = "views")
    private Integer views;

    @Column(name = "timestamp", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date timestamp;

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