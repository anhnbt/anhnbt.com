package com.anhnbt.blog.model;

import com.anhnbt.blog.entities.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class UserDto {
    @Pattern(regexp = "^[a-z][\\w]+$", message = "Tài khoản bao gồm các chữ cái thường hoặc số")
    @Size(min = 6, max = 29, message = "Tài khoản phải từ 6-29 ký tự")
    private String username;

    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu có tối thiểu 6 ký tự")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$", message = "Mật khẩu bao gồm số, chữ thường, chữ hoa và ký tự #?!@$%^&*-")
    private String password;

    private String confirmPassword;

    @Email
    @NotEmpty(message = "Email không được để trống")
    private String email;

    private Boolean enabled = true;

    private Collection<Role> roles;
}
