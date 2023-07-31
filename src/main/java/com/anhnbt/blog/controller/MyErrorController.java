package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    private static final Logger logger = LogManager.getLogger(MyErrorController.class);

    @RequestMapping("/error")
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError(HttpServletRequest request, Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Đã xảy ra lỗi");
        model.addAttribute("metaTag", metaTag);
        return "error/500";
    }
}