package com.anhnbt.blog.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class PostDTO {
    private Long id;
    @NotNull
    private Long category;

    @NotEmpty(message = "Tiêu đề không được để trống")
    @Size(min = 50, max = 60, message = "Tiêu đề phải từ 50-60 ký tự")
    private String title;

    private String thumbnailUrl;

    @Transient
    private MultipartFile thumbnail;

    @NotEmpty(message = "Nội dung không được để trống")
    @Size(max = 5000, message = "Nội dung không vượt quá 5000 ký tự")
    private String content;

    @NotEmpty(message = "Mô tả ngắn không được để trống")
    @Size(max = 160, message = "Mô tả ngắn không vượt quá 160 ký tự")
    private String description;
}
