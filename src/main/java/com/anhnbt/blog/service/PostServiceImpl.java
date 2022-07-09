package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.repository.PostRepository;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repo;

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<Post> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Post> findByPostName(String slug) {
        return repo.findByPostName(slug);
    }
}
