package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NicknameRepository extends JpaRepository<Nickname, Long> {
    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);

    Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable);
}
