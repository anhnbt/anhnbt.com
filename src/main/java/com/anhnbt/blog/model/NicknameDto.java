package com.anhnbt.blog.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NicknameDto {
    private Long id;
    private String name;
    private String slug;
    private String nickname;
    private Integer views;
    private Integer like;
    private Date timestamp;
    private Boolean enabled = true;
}
