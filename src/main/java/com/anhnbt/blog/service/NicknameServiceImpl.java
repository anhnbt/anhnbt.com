package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.repository.NicknameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NicknameServiceImpl implements NicknameService {

    @Autowired
    private NicknameRepository repo;

    @Override
    public Iterable<Nickname> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
