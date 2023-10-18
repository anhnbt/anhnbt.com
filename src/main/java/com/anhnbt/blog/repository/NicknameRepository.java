package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NicknameRepository extends JpaRepository<Nickname, Long> {
    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);

    Page<Nickname> findAllBySlugContainingIgnoreCase(String slug, Pageable pageable);

    List<Nickname> findAllByTimestampBetween(Date startOfDay, Date endOfDay);
}
