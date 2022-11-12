package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.repository.NicknameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NicknameServiceImpl implements NicknameService {

    @Autowired
    private NicknameRepository repo;

    @Override
    public Page<Nickname> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable) {
        return repo.findAllByEnabled(enabled, pageable);
    }

    @Override
    public Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable) {
        return repo.findAllBySlugContainingIgnoreCase(slug, pageable);
    }
}
