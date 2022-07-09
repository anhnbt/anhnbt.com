package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findByPostName(String slug);
}
