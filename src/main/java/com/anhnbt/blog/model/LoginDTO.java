package com.anhnbt.blog.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginDTO {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
