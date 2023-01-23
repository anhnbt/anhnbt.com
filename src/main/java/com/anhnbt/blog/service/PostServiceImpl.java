package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.repository.PostRepository;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Post> findAllByIdGreaterThan(Long id) {
        return repo.findAllByIdGreaterThan(id);
    }

    @Override
    public Optional<Post> findByPostName(String slug) {
        return repo.findByPostName(slug);
    }

    @Override
    public Post save(Post post) {
        return repo.save(post);
    }

    @Override
    public boolean existsByPostNameIgnoreCase(String postName) {
        return repo.existsByPostNameIgnoreCase(postName);
    }
}
