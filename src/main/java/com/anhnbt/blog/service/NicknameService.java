package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.model.PostDTO;
import com.anhnbt.blog.util.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface NicknameService {
    Page<Nickname> findAll(Pageable pageable);

    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);

    Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable);

    void create(NicknameDto nicknameDto);

    void update(Long id, NicknameDto nicknameDto);

    NicknameDto findById(Long id);

    void delete(Long id);

    long countPostsInDay(Date date);

    long countPostsInWeek(Date date);

    long countPostsInMonth(Date date);
}
