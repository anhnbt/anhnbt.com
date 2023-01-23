package com.anhnbt.blog.service;

import com.anhnbt.blog.common.StringCommon;
import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
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
        post.setId(postDto.getId());
        post.setCategory(postDto.getCategory());
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostName(StringCommon.createSlug(postDto.getPostTitle()));
        return repo.save(post);
    }

    @Override
    public PostDto findById(Long id) throws PostNotFoundException {
        Post post = repo.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found"));
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setPostTitle(post.getPostTitle());
        postDto.setPostContent(post.getPostContent());
        postDto.setCategory(post.getCategory());
        return postDto;
    }

    @Override
    public boolean existsByPostNameIgnoreCase(String postName) {
        return repo.existsByPostNameIgnoreCase(postName);
    }
}
