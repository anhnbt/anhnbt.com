package com.anhnbt.blog;

import com.anhnbt.blog.model.MetaTag;
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

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/lien-he")
    public String lienHe(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Liên hệ Nguyễn Bá Tuấn Anh");
        metaTag.setCanonical(baseUrl + "/lien-he");
        metaTag.setUrl(baseUrl + "/lien-he");
        metaTag.setType("article");
        metaTag.setDescription("Chào mừng bạn đến với https://anhnbt.com/ Nếu bạn sử dụng trang web này có nghĩa là bạn cần phải tuân theo những điều kiện sử dụng mà chúng tôi quy định tại đây...");
        metaTag.setImage(baseUrl + "/images/ki-tu-dac-biet-anhnbt.jpg");
        model.addAttribute("metaTag", metaTag);
        return "pages/lien-he";
    }

    @GetMapping("/gioi-thieu")
    public String gioiThieu() {
        return "pages/gioi-thieu";
    }

    @GetMapping("/dieu-khoan-su-dung")
    public String dieuKhoanSuDung() {
        return "pages/dieu-khoan-su-dung";
    }

    @GetMapping("/chinh-sach-bao-mat")
    public String chinhSachBaoMat() {
        return "pages/chinh-sach-bao-mat";
    }

    @GetMapping("/p/lien-he.html")
    public void lienHe301Redirect(HttpServletResponse response) {
        send301Redirect(response, "/lien-he");
    }

    @GetMapping("/p/gioi-thieu.html")
    public void gioiThieu301Redirect(HttpServletResponse response) {
        send301Redirect(response, "/gioi-thieu");
    }

    @GetMapping("/p/dieu-khoan-su-dung.html")
    public void dieuKhoanSuDung301Redirect(HttpServletResponse response) {
        send301Redirect(response, "/dieu-khoan-su-dung");
    }

    @GetMapping("/p/chinh-sach-bao-mat.html")
    public void chinhSachBaoMat301Redirect(HttpServletResponse response) {
        send301Redirect(response, "/chinh-sach-bao-mat");
    }

    private void send301Redirect(HttpServletResponse response, String newUrl) {
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader("Location", newUrl);
        response.setHeader("Connection", "close");
    }
}
