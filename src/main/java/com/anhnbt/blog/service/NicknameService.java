package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.domain.Pageable;

public interface NicknameService {
    Iterable<Nickname> findAll(Pageable pageable);
}
