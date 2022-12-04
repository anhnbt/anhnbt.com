package com.anhnbt.blog.service;

import com.anhnbt.blog.common.StringCommon;
import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.model.PostDto;
import com.anhnbt.blog.repository.PostRepository;
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
    public Post save(PostDto postDto) {
        Post post = new Post();
        post.setCategory(post.getCategory());
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostName(StringCommon.createSlug(postDto.getPostTitle()));
        return repo.save(post);
    }
}
