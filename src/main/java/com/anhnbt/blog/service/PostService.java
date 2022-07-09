package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;

import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    Optional<Post> findByPostName(String slug);
}
