package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.service.NicknameService;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private final NicknameService nicknameService;

    public PageController(PostService postService, NicknameService nicknameService) {
        this.postService = postService;
        this.nicknameService = nicknameService;
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
        Pageable sortedByIdDesc = PageRequest.of(1, 20, Sort.by("id").descending());
        model.addAttribute("nicknames", nicknameService.findAllByEnabled(true, sortedByIdDesc));
        return "pages/ky-tu-dac-biet";
    }

    @GetMapping("/chu-in-dam")
    public String chuInDam(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Chữ in đậm | Công cụ tạo chữ đậm Online");
        metaTag.setCanonical(baseUrl + "/chu-in-dam");
        metaTag.setUrl(baseUrl + "/chu-in-dam");
        metaTag.setType("article");
        metaTag.setDescription("Công cụ tạo chữ in đậm, chữ nghiêng trên status Facebook Fanpage đơn giản nhất. Chữ nét đậm không cần cài đặt font (phông) về điện thoại.");
        metaTag.setImage(baseUrl + "/images/chu-in-dam.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/chu-in-dam";
    }

    @GetMapping("/chu-kieu")
    public String chuKieu(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Chữ Kiểu đẹp - Công cụ tạo Chữ Kiểu Online");
        metaTag.setCanonical(baseUrl + "/chu-kieu");
        metaTag.setUrl(baseUrl + "/chu-kieu");
        metaTag.setType("article");
        metaTag.setDescription("Tạo Chữ Kiểu đẹp với 1001+ font chữ đẹp như gạch chân, gạch ngang, bong bóng, ô vuông, chữ khoảng trống,... Kí tự Facebook, Instagram, Zalo, Tiktok.");
        metaTag.setImage(baseUrl + "/images/chu-kieu.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/chu-kieu";
    }

    @GetMapping("/ten-game-hay")
    public String tenGameHay(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Tên Game Hay nhất cho game thủ Việt Nam");
        metaTag.setCanonical(baseUrl + "/ten-game-hay");
        metaTag.setUrl(baseUrl + "/ten-game-hay");
        metaTag.setType("article");
        metaTag.setDescription("Bạn đang bí ý tưởng để đặt tên game hay Liên Quân Mobile (LQ), Free Fire (FF)? Vào xem ngay những cái tên cực ngầu, hợp thời và gây được ấn tượng nhất.");
        metaTag.setImage(baseUrl + "/images/ten-lien-quan-hay.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/ten-game-hay";
    }

    @GetMapping("/ki-tu-vuong-mien")
    public String kiTuVuongMien(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự Vương Miện 亗 – Tên game Vương Miện đẹp");
        metaTag.setCanonical(baseUrl + "/ki-tu-vuong-mien");
        metaTag.setUrl(baseUrl + "/ki-tu-vuong-mien");
        metaTag.setType("article");
        metaTag.setDescription("Kí tự Vương Miện hay Kí tự đặc biệt Vương Miện một trong những kí tự hot trend hiện nay. Giúp bạn tạo những tên game hay cho FF, Liên Quân, PUBG.");
        metaTag.setImage(baseUrl + "/images/ki-tu-vuong-mien.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/ki-tu-vuong-mien";
    }

    @GetMapping("/ki-tu-tang-hinh")
    public String kiTuTangHinh(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự tàng hình – Đổi tên Free Fire không tên");
        metaTag.setCanonical(baseUrl + "/ki-tu-tang-hinh");
        metaTag.setUrl(baseUrl + "/ki-tu-tang-hinh");
        metaTag.setType("article");
        metaTag.setDescription("Kí tự tàng hình, hay kí tự ẩn là một trong những kí tự hot nhất giúp bạn tạo tên game tàng hình Free Fire (FF) không tên.");
        metaTag.setImage(baseUrl + "/images/ki-tu-tang-hinh.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/ki-tu-tang-hinh";
    }

    private void send301Redirect(HttpServletResponse response, String newUrl) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", newUrl);
        response.setHeader("Connection", "close");
    }
}
