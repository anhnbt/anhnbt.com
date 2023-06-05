package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.User;
import com.anhnbt.blog.exception.EmailExistsException;
import com.anhnbt.blog.exception.UsernameExistsException;
import com.anhnbt.blog.model.UserDto;

public interface UserService {
    User save(UserDto userDto) throws EmailExistsException, UsernameExistsException;

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
