package com.anhnbt.blog.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTO {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
