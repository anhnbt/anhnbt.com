package com.anhnbt.blog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaTag {
    private String canonical;
    private String url;
    private String type;
    private String title;
    private String description;
    private String image;
}
