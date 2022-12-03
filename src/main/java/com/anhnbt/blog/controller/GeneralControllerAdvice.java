package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GeneralControllerAdvice {

    @ModelAttribute
    public void userModelAttribute(Authentication auth, Model model) {
        if (auth != null && auth.isAuthenticated()) {
            User user = (User) auth.getPrincipal();
            if (user != null) {
                model.addAttribute("user", user);
            }
        }
    }

    @ModelAttribute
    public void metaTagAttributes(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("AnhNBT");
        model.addAttribute("metaTag", metaTag);
    }

}
