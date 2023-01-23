package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    List<Post> findAllByIdGreaterThan(Long id);

    Optional<Post> findByPostName(String slug);

    Post save(Post post);

    boolean existsByPostNameIgnoreCase(String postName);

}
