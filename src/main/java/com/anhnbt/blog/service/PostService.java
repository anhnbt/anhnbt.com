package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    List<Post> findAllByIdGreaterThan(Long id);

    Optional<Post> findByPostName(String slug);

    Post save(PostDTO postDto);

    PostDTO findById(Long id) throws PostNotFoundException;

    boolean existsByPostNameIgnoreCase(String postName);

}
