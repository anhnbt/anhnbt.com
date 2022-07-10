package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class PageController {

    @Value(value = "${app.base-url}")
    private String baseUrl;

    private final PostService postService;

    public PageController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String home(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("AnhNBT BLOG - Trang Blog của Nguyễn Bá Tuấn Anh");
        metaTag.setCanonical(baseUrl);
        metaTag.setUrl(baseUrl);
        metaTag.setType("website");
        metaTag.setDescription("AnhNBT là nơi chia sẻ những tiện ích hay công cụ về Game Mobile của Nguyễn Bá Tuấn Anh. Mời bạn ghé thăm trang và sử dụng công cụ tạo tên mới nhất của mình");
        metaTag.setImage(baseUrl + "/images/ki-tu-dac-biet-anhnbt.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("posts", postService.findAll());
        return "index";
    }
    @GetMapping("/ky-tu-dac-biet")
    public String kiTuDacBiet(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự đặc biệt AnhNBT - #1 Công cụ tạo tên game Mobile");
        metaTag.setCanonical(baseUrl + "/ky-tu-dac-biet");
        metaTag.setUrl(baseUrl + "/ky-tu-dac-biet");
        metaTag.setType("article");
        metaTag.setDescription("1001 Kí tự đặc biệt FF tạo tên kí tự đẹp Quân đoàn Free Fire, Liên Quân (LQ), PUBG như mặt quỷ ╰‿╯, mặt cười ×͜× , Cây dù ☂ và bảng kí hiệu đặc biệt.");
        metaTag.setImage(baseUrl + "/images/ki-tu-dac-biet-anhnbt.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/ky-tu-dac-biet";
    }

    private void send301Redirect(HttpServletResponse response, String newUrl) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", newUrl);
        response.setHeader("Connection", "close");
    }
}
