package com.anhnbt.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MetaTag {
    private String canonical;
    private String url;
    private String type;
    private String title;
    private String description;
    private String image;

    public MetaTag(String title) {
        this.title = title;
    }
}
