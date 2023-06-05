package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.repository.NicknameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Override
    public void create(NicknameDto nicknameDto) {
        Nickname nickname = new Nickname();
        mapToEntity(nicknameDto, nickname);
        nickname.setTimestamp(new Date());
        nickname.setCountLike(0);
        nickname.setViews(0);
        repo.save(nickname);
    }

    @Override
    public void update(Long id, NicknameDto nicknameDto) {
        Nickname nickname = repo.findById(id)
                .orElseThrow(null);
        mapToEntity(nicknameDto, nickname);
        nickname.setTimestamp(new Date());
        repo.save(nickname);
    }

    @Override
    public NicknameDto findById(Long id) {
        return repo.findById(id).map(e -> mapToDTO(e, new NicknameDto())).orElseThrow(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    private NicknameDto mapToDTO(Nickname nickname, NicknameDto nicknameDto) {
        nicknameDto.setId(nickname.getId());
        nicknameDto.setNickname(nickname.getNickname());
        nicknameDto.setTimestamp(nickname.getTimestamp());
        nicknameDto.setSlug(nickname.getSlug());
        nicknameDto.setEnabled(nickname.getEnabled());
        return nicknameDto;
    }

    private Nickname mapToEntity(NicknameDto nicknameDto, Nickname nickname) {
        nickname.setNickname(nicknameDto.getNickname());
        nickname.setTimestamp(nicknameDto.getTimestamp());
        nickname.setSlug(nicknameDto.getSlug());
        nickname.setEnabled(nicknameDto.getEnabled());
        return nickname;
    }
}
