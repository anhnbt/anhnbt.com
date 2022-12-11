package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    List<Post> findAllByIdGreaterThan(Long id);

    Optional<Post> findByPostName(String slug);

    Post save(PostDto postDto);

    PostDto findById(Long id) throws PostNotFoundException;
}
