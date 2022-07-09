package com.anhnbt.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchemaLdJson implements Serializable {
    @JsonProperty("@context")
    private String context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("headline")
    private String headline;

    @JsonProperty("datePublished")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone="Asia/Ho_Chi_Minh")
    private Date datePublished;

    @JsonProperty("dateModified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone="Asia/Ho_Chi_Minh")
    private Date dateModified;

    private List<String> image;

    private AuthorLdJson author;
}
