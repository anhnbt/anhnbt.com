package com.anhnbt.blog.controller;

import com.anhnbt.blog.common.Constants;
import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.*;
import com.anhnbt.blog.repository.PostRepository;
import com.anhnbt.blog.service.CategoryService;
import com.anhnbt.blog.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class PostController {

    private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

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
            postRepository.save(post);
        } catch (Exception e) {
            logger.debug("Exception khi thực hiện PostController.details", e);
        }

        modelAndView.addObject("schemaLdJson", jsonAsString);
        modelAndView.addObject("metaTag", metaTag);
        modelAndView.addObject("post", post);
        modelAndView.addObject("enabledAds", false);
        return modelAndView;
    }

    @ModelAttribute
    public void categoriesAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }

    @GetMapping("/admin/posts")
    public ModelAndView showAllPost() {
        ModelAndView modelAndView = new ModelAndView("admin/posts");
        modelAndView.addObject("posts", postService.findAll());
        modelAndView.addObject("metaTag", new MetaTag("Tất cả bài viết"));
        return modelAndView;
    }

    @GetMapping("/admin/post-new")
    public ModelAndView createPost() {
        ModelAndView modelAndView = new ModelAndView("admin/post-new");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("metaTag", new MetaTag("Thêm bài viết"));
        return modelAndView;
    }

    @PostMapping("/admin/post-new")
    public String createPost(@Validated @ModelAttribute("post") PostDto post,
                          BindingResult result,
                          RedirectAttributes redirect) {
        try {
            if (result.hasErrors()) {
                return "admin/post-new";
            }
            postService.save(post);
            redirect.addFlashAttribute(Constants.MESSAGE, new Message(Constants.MESSAGE_TYPE.SUCCESS, "Thêm bài viết thành công!"));
        } catch (Exception e) {
            logger.debug("Exception when /admin/post-new", e);
            redirect.addFlashAttribute(Constants.MESSAGE, new Message(Constants.MESSAGE_TYPE.DANGER, "Thêm bài viết không thành công!"));
        }
        return "redirect:/admin/post-new";
    }
}
