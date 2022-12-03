package com.anhnbt.blog.service;

import com.anhnbt.blog.entities.User;
import com.anhnbt.blog.exception.EmailExistsException;
import com.anhnbt.blog.exception.UsernameExistsException;
import com.anhnbt.blog.model.UserDto;
import com.anhnbt.blog.repository.RoleRepository;
import com.anhnbt.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(UserDto accountDto) throws EmailExistsException, UsernameExistsException {
        if (existsByEmail(accountDto.getEmail())) {
            throw new EmailExistsException
                    ("There is an account with that email address: " + accountDto.getEmail());
        }
        if (existsByUsername(accountDto.getUsername())) {
            throw new UsernameExistsException
                    ("There is an account with that username: " + accountDto.getUsername());
        }
        User user = new User();
        user.setUsername(accountDto.getUsername());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setEnabled(accountDto.getEnabled());
        user.setRoles(accountDto.getRoles());
        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
