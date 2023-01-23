package com.anhnbt.blog.model;

import com.anhnbt.blog.entities.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private Category category;

    @NotEmpty(message = "Tiêu đề không được để trống")
    @Size(min = 50, max = 60, message = "Tiêu đề phải từ 50-60 ký tự")
    private String postTitle;

    @NotEmpty(message = "Nội dung không được để trống")
    @Size(max = 5000, message = "Nội dung không vượt quá 5000 ký tự")
    private String postContent;
}
