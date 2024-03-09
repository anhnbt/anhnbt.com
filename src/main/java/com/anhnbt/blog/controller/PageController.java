package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.service.NicknameService;
import com.anhnbt.blog.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class PageController {

    @Value(value = "${app.base-url}")
    private String baseUrl;

    private final PostService postService;
    private final NicknameService nicknameService;

    @Value(value = "${app.enabledAds}")
    private Boolean enabledAds;

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
        model.addAttribute("enabledAds", false);
        // Bỏ qua 4 bài viết đầu tiên
        model.addAttribute("posts", postService.findAllByIdGreaterThan(4L));
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
        model.addAttribute("enabledAds", enabledAds);
        Pageable sortedByIdDesc = PageRequest.of(0, 20, Sort.by("id").descending());
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
        model.addAttribute("enabledAds", enabledAds);
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
        model.addAttribute("enabledAds", enabledAds);
        return "pages/chu-kieu";
    }

    @GetMapping("/ten-game-hay")
    public String tenGameHay(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Sở hữu tên game hay nổi bật trong thế giới ảo");
        metaTag.setCanonical(baseUrl + "/ten-game-hay");
        metaTag.setUrl(baseUrl + "/ten-game-hay");
        metaTag.setType("article");
        metaTag.setDescription("Sở hữu tên game hay là điều mà nhiều game thủ quan tâm? Vào xem ngay những cái tên cực ngầu, hợp thời và gây được ấn tượng nhất.");
        metaTag.setImage(baseUrl + "/images/ten-lien-quan-hay.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
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
        model.addAttribute("enabledAds", enabledAds);
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
        model.addAttribute("enabledAds", enabledAds);
        return "pages/ki-tu-tang-hinh";
    }

    @GetMapping("/ki-tu-dac-biet-chu-nho")
    public String kiTuDacBietChuNho(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự đặc biệt chữ nhỏ ²⁰²³");
        metaTag.setCanonical(baseUrl + "/ki-tu-dac-biet-chu-nho");
        metaTag.setUrl(baseUrl + "/ki-tu-dac-biet-chu-nho");
        metaTag.setType("article");
        metaTag.setDescription("Bộ công cụ tạo tên game bằng bảng kí tự đặc biệt chữ nhỏ (chữ siêu nhỏ, chữ nhỏ ở giữa) như ↭ⁱˡᵒᵛᵉᵘɞ, ⁀ᶦᵈᵒᶫ, ²⁴ʰYêü.");
        metaTag.setImage(baseUrl + "/images/ki-tu-chu-nho.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
        return "pages/ki-tu-dac-biet-chu-nho";
    }

    @GetMapping("/tao-chu-i-am")
    public String taoChuIAm(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Công cụ tạo chữ IAM (IͥAͣMͫ) nhỏ xíu trên đầu");
        metaTag.setCanonical(baseUrl + "/tao-chu-i-am");
        metaTag.setUrl(baseUrl + "/tao-chu-i-am");
        metaTag.setType("article");
        metaTag.setDescription("Công cụ tạo kí tự đặc biệt kiểu IAM (IͥAͣMͫ) trên đầu sử dụng dễ dàng và đơn giản. Có nhiều tùy chọn ký tự trên đầu khác chẳng hạn như Aͭnͧhͣn.");
        metaTag.setImage(baseUrl + "/images/ki-tu-i-am-nho.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
        return "pages/tao-chu-i-am";
    }

    @GetMapping("/ki-tu-qua-tao")
    public String kiTuQuaTao(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự quả táo \uD83C\uDF4E – Tên game quả táo đẹp");
        metaTag.setCanonical(baseUrl + "/ki-tu-qua-tao");
        metaTag.setUrl(baseUrl + "/ki-tu-qua-tao");
        metaTag.setType("article");
        metaTag.setDescription("Kí tự quả táo iPhone \uF8FF, hay kí tự quả táo cắn dở được nhiều bạn thắc mắc và hỏi làm sao để hiển thị trong Free Fire (FF).");
        metaTag.setImage(baseUrl + "/images/ki-tu-qua-tao.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
        return "pages/ki-tu-qua-tao";
    }

    @GetMapping("/ki-tu-khoang-trong-ff")
    public String kiTuKhoangTrongFF(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Kí tự khoảng trống FF - Dấu cách đặc biệt");
        metaTag.setCanonical(baseUrl + "/ki-tu-khoang-trong-ff");
        metaTag.setUrl(baseUrl + "/ki-tu-khoang-trong-ff");
        metaTag.setType("article");
        metaTag.setDescription("Dùng làm tên game đẹp độc đáo với ký tự khoảng trống hay dấu cách đặc biệt dành cho game Free Fire (FF), Liên Quân Mobile...");
        metaTag.setImage(baseUrl + "/images/ki-tu-khoang-trong-ff.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
        return "pages/ki-tu-khoang-trong-ff";
    }

    @GetMapping("/ki-tu-trai-tim")
    public String kiTuTraiTim(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Chinh phục trái tim người chơi: Sử dụng kí tự trái tim trong game");
        metaTag.setCanonical(baseUrl + "/ki-tu-trai-tim");
        metaTag.setUrl(baseUrl + "/ki-tu-trai-tim");
        metaTag.setType("article");
        metaTag.setDescription("Chinh phục trái tim người chơi bằng cách sử dụng kí tự trái tim trong game, với những ký tự đặc biệt tạo hình trái tim, bạn dễ dàng thể hiện thiện cảm tốt.");
        metaTag.setImage(baseUrl + "/images/ki-tu-trai-tim.jpg");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("enabledAds", enabledAds);
        return "pages/ki-tu-trai-tim";
    }

    private void send301Redirect(HttpServletResponse response, String newUrl) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", newUrl);
        response.setHeader("Connection", "close");
    }
}
