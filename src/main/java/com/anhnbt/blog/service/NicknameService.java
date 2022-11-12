package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NicknameService {
    Page<Nickname> findAll(Pageable pageable);

    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);

    Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable);
}
