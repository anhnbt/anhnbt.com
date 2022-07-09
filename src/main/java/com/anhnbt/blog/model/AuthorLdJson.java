package com.anhnbt.blog.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorLdJson {
    @JsonProperty("@type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    public AuthorLdJson(String type, String name, String url) {
        this.type = type;
        this.name = name;
        this.url = url;
    }
}
