package com.anhnbt.blog.repository;

import com.anhnbt.blog.entities.Nickname;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NicknameRepository extends PagingAndSortingRepository<Nickname, Long> {
}
