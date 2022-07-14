package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NicknameRepository extends PagingAndSortingRepository<Nickname, Long> {
    Page<Nickname> findAllByEnabled(Boolean enabled, Pageable pageable);
}
