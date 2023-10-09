package com.anhnbt.blog.controller;

import com.anhnbt.blog.common.Constants;
import com.anhnbt.blog.entities.Post;
import com.anhnbt.blog.exception.PostExistsException;
import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.*;
import com.anhnbt.blog.repository.PostRepository;
import com.anhnbt.blog.service.CategoryService;
import com.anhnbt.blog.service.PostService;
import com.anhnbt.blog.storage.StorageException;
import com.anhnbt.blog.storage.StorageService;
import com.anhnbt.blog.util.WebUtils;
import com.anhnbt.blog.validator.FileValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping
public class PostController {

    public static final String REDIRECT_ADMIN_POSTS = "redirect:/admin/posts";
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileValidator fileValidator;

    @Autowired
    private StorageService storageService;

    @Value(value = "${app.base-url}")
    private String baseUrl;

    @GetMapping("/p/{slug}.html")
    public ModelAndView details(@PathVariable("slug") String slug) throws PostNotFoundException {
        ModelAndView modelAndView = new ModelAndView("posts");
        Post post = postService.findByPostName(slug).orElseThrow(() -> new PostNotFoundException("Not found"));
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
            log.debug("Exception khi thực hiện PostController.details", e);
        }

        modelAndView.addObject("schemaLdJson", jsonAsString);
        modelAndView.addObject("metaTag", new MetaTag(baseUrl, post));
        modelAndView.addObject("post", post);
        modelAndView.addObject("enabledAds", false);
        return modelAndView;
    }

    @ModelAttribute
    public void categoriesAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/admin/posts")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("admin/post/list");
        modelAndView.addObject("posts", postService.findAllByOrderByIdDesc());
        modelAndView.addObject("metaTag", new MetaTag(WebUtils.getMessage("post.list.headline")));
        return modelAndView;
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/admin/posts/add")
    public String add(@ModelAttribute("post") PostDTO postDTO) {
        return "admin/post/add";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/admin/posts/add")
    public String add(@Validated @ModelAttribute("post") PostDTO postDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        try {
            MultipartFile thumbnailFile = postDTO.getThumbnail();
            fileValidator.validate(postDTO, bindingResult);
            if (bindingResult.hasErrors()) {
                return "admin/post/add";
            }
            try {
                String thumbnailUrl = thumbnailFile.getOriginalFilename();
                storageService.store(thumbnailFile);
                postDTO.setThumbnailUrl(thumbnailUrl);
            } catch (StorageException e) {
                postDTO.setThumbnailUrl("150.png");
            }
            postService.create(postDTO);
            redirectAttributes.addFlashAttribute(Constants.MSG_SUCCESS, WebUtils.getMessage("post.create.success"));
        } catch (PostExistsException | PostNotFoundException e) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, e.getMessage());
        } catch (Exception e) {
            log.debug("Exception when /admin/posts/add", e);
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Thêm bài viết không thành công!");
        }
        return REDIRECT_ADMIN_POSTS;
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/admin/posts/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws PostNotFoundException {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("metaTag", new MetaTag(WebUtils.getMessage("post.edit.headline")));
        return "admin/post/edit";
    }



    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/admin/posts/delete-thumb/{id}")
    public String deleteThumb(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws IOException, PostNotFoundException {
        PostDTO postDTO = postService.findById(id);
        Resource file = storageService.loadAsResource(postDTO.getThumbnailUrl());
        try {
            // Delete file or directory
            if (file.exists()) {
                Files.delete(file.getFile().toPath());
                postDTO.setThumbnailUrl("");
                postService.update(id, postDTO);
            }
            redirectAttributes.addFlashAttribute(Constants.MSG_SUCCESS, "Xóa thumbnail thành công!");
        } catch (NoSuchFileException ex) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "File không tồn tại: " + file.getFile().toPath());
        } catch (DirectoryNotEmptyException ex) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Thư mục trống");
        } catch (IOException ex) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, ex.getMessage());
        } catch (PostExistsException e) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Bài viết không tồn tại");
            return REDIRECT_ADMIN_POSTS;
        }
        return "redirect:/admin/posts/edit/" + id;
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/admin/posts/edit/{id}")
    public String edit(@PathVariable Long id,
                           @ModelAttribute("post") PostDTO postDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        try {
            MultipartFile thumbnailFile = null;
            if (postDTO.getThumbnail() != null && !postDTO.getThumbnail().isEmpty()) {
                thumbnailFile = postDTO.getThumbnail();
                fileValidator.validate(postDTO, bindingResult);
            }
            if (bindingResult.hasErrors()) {
                return "admin/post/edit";
            }
            try {
                if (thumbnailFile != null) {
                    String thumbnailUrl = thumbnailFile.getOriginalFilename();
                    storageService.store(thumbnailFile);
                    postDTO.setThumbnailUrl(thumbnailUrl);
                }
            } catch (StorageException e) {
                if (StringUtils.isEmpty(postDTO.getThumbnailUrl())) {
                    postDTO.setThumbnailUrl("150.png");
                }
            }
            postService.update(id, postDTO);
            redirectAttributes.addFlashAttribute(Constants.MSG_SUCCESS, WebUtils.getMessage("post.update.success"));
        } catch (PostExistsException | PostNotFoundException e) {
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, e.getMessage());
        } catch (Exception e) {
            log.debug("Exception when /admin/posts/edit/{0}: {1}", id, e);
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Chỉnh sửa bài viết không thành công!");
        }
        return REDIRECT_ADMIN_POSTS;
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/admin/posts/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        postService.delete(id);
        redirectAttributes.addFlashAttribute(Constants.MSG_INFO, WebUtils.getMessage("post.delete.success"));
        return REDIRECT_ADMIN_POSTS;
    }
}
