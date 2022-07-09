package com.anhnbt.blog.entities;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "post_title", nullable = false, length = 110)
    private String postTitle;

    @Column(name = "post_name", nullable = false, length = 200)
    private String postName;

    @Column(name = "post_thumb")
    private String postThumb;

    @Lob
    @Column(name = "post_content", nullable = false)
    private String postContent;

    @Column(name = "post_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postDate;

    @Column(name = "post_modified", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postModified;

    @Column(name = "post_view_count", nullable = false)
    private Integer postViewCount;

    public String getContentEscape() {
        if (StringUtils.isNotEmpty(postContent)) {
            return StringEscapeUtils.unescapeHtml4(postContent);
        }
        return "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostThumb() {
        return postThumb;
    }

    public void setPostThumb(String postThumb) {
        this.postThumb = postThumb;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Integer getPostViewCount() {
        return postViewCount;
    }

    public void setPostViewCount(Integer postViewCount) {
        this.postViewCount = postViewCount;
    }

}