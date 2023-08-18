package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostExistsException;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    List<Post> findAllByOrderByIdDesc();

    List<Post> findAllByIdGreaterThan(Long id);

    Optional<Post> findByPostName(String slug);

    void create(PostDTO postDto) throws PostNotFoundException, PostExistsException;

    void update(Long id, PostDTO postDto) throws PostNotFoundException, PostExistsException;

    PostDTO findById(Long id) throws PostNotFoundException;

    boolean existsByPostNameIgnoreCase(String postName);

    boolean existsByPostNameIgnoreCaseAndIdNot(String postName, Long id);

    void delete(Long id);
}
