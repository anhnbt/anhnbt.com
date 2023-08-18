package com.anhnbt.blog.model;

import com.anhnbt.blog.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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

    public MetaTag(String baseUrl, Post post) {
        this.setCanonical(baseUrl + "/p/" + post.getPostName() + ".html");
        this.setUrl(baseUrl + "/p/" + post.getPostName() + ".html");
        this.setTitle(post.getPostTitle());
        this.setType("article");
        if (StringUtils.isNotEmpty(post.getPostDescription())) {
            this.setDescription(post.getPostDescription());
        }
        if (StringUtils.isNotEmpty(post.getPostThumb())) {
            this.setImage(baseUrl + "/uploads/" + post.getPostThumb());
        }
    }
}
