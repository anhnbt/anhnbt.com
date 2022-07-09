package com.anhnbt.blog.controller;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.model.AuthorLdJson;
import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.model.SchemaLdJson;
import com.anhnbt.blog.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;

    @Value(value = "${app.base-url}")
    private String baseUrl;

    @GetMapping("/p/{slug}.html")
    private ModelAndView details(@PathVariable("slug") String slug) {
        ModelAndView modelAndView = new ModelAndView("posts");
        Post post = postService.findByPostName(slug).orElseThrow(() -> new RuntimeException("Not found"));
        MetaTag metaTag = new MetaTag();
        metaTag.setCanonical(baseUrl + "/p/" + slug + ".html");
        metaTag.setUrl(baseUrl + "/p/" + slug + ".html");
        metaTag.setTitle(post.getPostTitle());
        metaTag.setType("article");
//        metaTag.setDescription(post.getPostContent());
        metaTag.setImage(baseUrl + "/uploads/" + post.getPostThumb());

        SchemaLdJson json = new SchemaLdJson();
        json.setContext("https://schema.org");
        json.setType("NewsArticle");
        json.setHeadline(post.getPostTitle());
        json.setDatePublished(post.getPostDate());
        json.setDateModified(post.getPostModified());
        json.setAuthor(new AuthorLdJson("Person", "Nguyễn Bá Tuấn Anh", baseUrl));
        json.setImage(List.of(baseUrl + "/uploads/" + post.getPostThumb()));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonAsString;
        try {
            jsonAsString = objectMapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        modelAndView.addObject("schemaLdJson", jsonAsString);
        modelAndView.addObject("metaTag", metaTag);
        modelAndView.addObject("post", post);
        return modelAndView;
    }
}
