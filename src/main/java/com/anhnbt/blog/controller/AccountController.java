package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public String general(Model model, Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/";
        }
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Đăng nhập");
        model.addAttribute("metaTag", metaTag);
        return "pages/account/general";
    }

//    @GetMapping("/security")
//    public String security() {
//
//    }
}
