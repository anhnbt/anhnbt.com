package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByPostName(String slug);
}
