package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("500 Internal Server Error");
        model.addAttribute("metaTag", metaTag);
        return "error/500";
    }
}