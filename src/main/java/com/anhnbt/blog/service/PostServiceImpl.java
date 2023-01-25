package com.anhnbt.blog.service;

import com.anhnbt.blog.common.StringCommon;
import com.anhnbt.blog.entities.Category;
import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.PostDTO;
import com.anhnbt.blog.repository.CategoryRepository;
import com.anhnbt.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllByIdGreaterThan(Long id) {
        return postRepository.findAllByIdGreaterThan(id);
    }

    @Override
    public Optional<Post> findByPostName(String slug) {
        return postRepository.findByPostName(slug);
    }

    @Override
    public void create(PostDTO postDto) throws PostNotFoundException {
        Post post = new Post();
        mapToEntity(postDto, post);
        postRepository.save(post);
    }

    @Override
    public void update(Long id, PostDTO postDTO) throws PostNotFoundException {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
        mapToEntity(postDTO, post);
        postRepository.save(post);
    }

    @Override
    public PostDTO findById(Long id) throws PostNotFoundException {
        return postRepository.findById(id)
                .map(p -> mapToDTO(p, new PostDTO()))
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    private PostDTO mapToDTO(Post post, PostDTO postDTO) {
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getPostTitle());
        postDTO.setContent(post.getPostContent());
        postDTO.setCategory(post.getCategory() == null ? null : post.getCategory().getId());
        return postDTO;
    }

    private Post mapToEntity(PostDTO postDTO, Post post) throws PostNotFoundException {
        post.setPostTitle(postDTO.getTitle());
        post.setPostName(StringCommon.createSlug(postDTO.getTitle()));
        post.setPostContent(postDTO.getContent());
        Category category =postDTO.getCategory() == null ? null : categoryRepository
                .findById(postDTO.getCategory())
                .orElseThrow(() -> new PostNotFoundException("Category not found"));
        post.setCategory(category);
        return post;
    }

    @Override
    public boolean existsByPostNameIgnoreCase(String postName) {
        return postRepository.existsByPostNameIgnoreCase(postName);
    }
}
