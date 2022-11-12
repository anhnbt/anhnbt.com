package com.anhnbt.blog.controller;

import com.anhnbt.blog.entities.Nickname;
import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.service.NicknameService;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("search")
public class SearchController {

    @Value(value = "${app.base-url}")
    private String baseUrl;

    @Autowired
    private PostService postService;

    @Autowired
    private NicknameService nicknameService;

    @GetMapping
    public String search(Model model,
                         @RequestParam(value = "s") String query,
                         @PageableDefault(size = 20) @SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)})
                         Pageable pageable) {
        Page<Nickname> nicknames = nicknameService.findAllBySlugContainingIgnoreCase(query, pageable);
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle(query + " | AnhNBT BLOG");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", false);
        model.addAttribute("nicknames", nicknames);
        int totalPages = nicknames.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "search";
    }

}
