package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByIdDesc();

    Optional<Post> findByPostName(String slug);

    List<Post> findAllByIdGreaterThan(Long id);

    boolean existsByPostNameIgnoreCase(String postName);
    
    boolean existsByPostNameIgnoreCaseAndIdNot(String postName, Long id);
}
