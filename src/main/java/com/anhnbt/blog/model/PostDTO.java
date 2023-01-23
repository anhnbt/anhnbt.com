package com.anhnbt.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostDTO {
    @Pattern(regexp = "[a-zA-Z0-9 ]")
    @Size(max = 255)
    private String title;
}
