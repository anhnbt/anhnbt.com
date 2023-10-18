package com.anhnbt.blog.service;

import com.anhnbt.blog.common.StringCommon;
import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.repository.NicknameRepository;
import com.anhnbt.blog.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public long countPostsInDay(Date date) {
        Date startOfDay = DateUtils.truncateTimeToStartOfDay(date);
        Date endOfDay = DateUtils.truncateTimeToEndOfDay(date);
        List<Nickname> nicknames = repo.findAllByTimestampBetween(startOfDay, endOfDay);
        return nicknames.size();
    }

    @Override
    public long countPostsInWeek(Date date) {
        Date startOfWeek = DateUtils.getStartOfWeek(date);
        Date endOfWeek = DateUtils.getEndOfWeek(date);
        List<Nickname> nicknames = repo.findAllByTimestampBetween(startOfWeek, endOfWeek);
        return nicknames.size();
    }

    @Override
    public long countPostsInMonth(Date date) {
        Date startOfMonth = DateUtils.getStartOfMonth(date);
        Date endOfMonth = DateUtils.getEndOfMonth(date);
        List<Nickname> nicknames = repo.findAllByTimestampBetween(startOfMonth, endOfMonth);
        return nicknames.size();
    }

    private NicknameDto mapToDTO(Nickname nickname, NicknameDto nicknameDto) {
        nicknameDto.setId(nickname.getId());
        nicknameDto.setNickname(nickname.getNickname());
        nicknameDto.setName(nickname.getName());
        nicknameDto.setSlug(nickname.getSlug());
        nicknameDto.setTimestamp(nickname.getTimestamp());
        nicknameDto.setEnabled(nickname.getEnabled());
        return nicknameDto;
    }

    private Nickname mapToEntity(NicknameDto nicknameDto, Nickname nickname) {
        nickname.setNickname(nicknameDto.getNickname());
        nickname.setName(nicknameDto.getName());
        nickname.setSlug(StringCommon.createSlug(nicknameDto.getName()));
        nickname.setTimestamp(nicknameDto.getTimestamp());
        nickname.setEnabled(nicknameDto.getEnabled());
        return nickname;
    }
}
