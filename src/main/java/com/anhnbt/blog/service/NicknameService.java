package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.model.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NicknameService {
    Page<Nickname> findAll(Pageable pageable);

    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);

    Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable);

    void create(NicknameDto nicknameDto);

    void update(Long id, NicknameDto nicknameDto);

    NicknameDto findById(Long id);

    void delete(Long id);
}
