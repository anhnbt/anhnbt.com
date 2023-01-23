package com.anhnbt.blog.controller;

import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.AuthorLdJson;
import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.model.SchemaLdJson;
import com.anhnbt.blog.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class PostController {

    private static final Logger logger = LogManager.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Value(value = "${app.base-url}")
    private String baseUrl;

    @GetMapping("/p/{slug}.html")
    public ModelAndView details(@PathVariable("slug") String slug) throws PostNotFoundException {
        ModelAndView modelAndView = new ModelAndView("posts");
        Post post = postService.findByPostName(slug).orElseThrow(() -> new PostNotFoundException("Not found"));
        MetaTag metaTag = new MetaTag();
        metaTag.setCanonical(baseUrl + "/p/" + slug + ".html");
        metaTag.setUrl(baseUrl + "/p/" + slug + ".html");
        metaTag.setTitle(post.getPostTitle());
        metaTag.setType("article");
        // TODO
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
        String jsonAsString = null;
        try {
            jsonAsString = objectMapper.writeValueAsString(json);

            post.setPostViewCount(post.getPostViewCount() + 1);
            if (postService.save(post) == null) {
                logger.info("Không cập nhật được post view");
            }
        } catch (JsonProcessingException e) {
            // TODO 500 error page
        } catch (Exception e) {
            // TODO 500 error page
        }

        modelAndView.addObject("schemaLdJson", jsonAsString);
        modelAndView.addObject("metaTag", metaTag);
        modelAndView.addObject("post", post);
        modelAndView.addObject("enabledAds", false);
        return modelAndView;
    }
}
