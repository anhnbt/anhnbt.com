package com.anhnbt.blog.validator;

import com.anhnbt.blog.entities.User;
import com.anhnbt.blog.model.UserDto;
import com.anhnbt.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "", "Mật khẩu không khớp");
        }

        if (userService.existsByEmail(user.getEmail())) {
            errors.rejectValue("email", "", "Email đã tồn tại");
        }

        if (userService.existsByUsername(user.getUsername())) {
            errors.rejectValue("username", "", "Username đã tồn tại");
        }
    }
}