package com.anhnbt.blog.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "post_title", nullable = false, length = 110)
    private String postTitle;

    @Column(name = "post_name", length = 200)
    private String postName;

    @Column(name = "post_thumb")
    private String postThumb;

    @Lob
    @Column(name = "post_content", nullable = false)
    private String postContent;

    @Column(name = "post_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postDate = new Date();

    @Column(name = "post_modified")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postModified = new Date();

    @Column(name = "post_view_count")
    private Integer postViewCount = 0;

    public String getContentEscape() {
        if (StringUtils.isNotEmpty(postContent)) {
            return StringEscapeUtils.unescapeHtml4(postContent);
        }
        return "";
    }

}