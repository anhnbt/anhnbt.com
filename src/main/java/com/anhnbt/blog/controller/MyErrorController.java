package com.anhnbt.blog.controller;

import com.anhnbt.blog.model.MetaTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MyErrorController implements ErrorController {

    private static final Logger logger = LogManager.getLogger(MyErrorController.class);
    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
        logger.error("Exception handleError: {}, {}", errorAttributes.get("path"), errorAttributes.get("error"));
        ModelAndView model;
        MetaTag metaTag = new MetaTag();
        int status = (int) errorAttributes.get("status");
        if (HttpStatus.NOT_FOUND.value() == status) {
            model = new ModelAndView("error/404");
            model.setStatus(HttpStatus.NOT_FOUND);
            metaTag.setTitle("404 Not Found");
            metaTag.setDescription("Bài viết không tồn tại");
        } else if (HttpStatus.UNAUTHORIZED.value() == status) {
            model = new ModelAndView("error/500");
            model.setStatus(HttpStatus.UNAUTHORIZED);
            metaTag.setTitle("401 Unauthorized");
            metaTag.setDescription("Bạn không được phép truy cập trang này");
        } else if (HttpStatus.FORBIDDEN.value() == status) {
            model = new ModelAndView("error/500");
            model.setStatus(HttpStatus.FORBIDDEN);
            metaTag.setTitle("403 Forbidden");
            metaTag.setDescription("Truy cập bị từ chối");
        } else {
            model = new ModelAndView("error/500");
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            metaTag.setTitle("Đã xảy ra lỗi nghiêm trọng");
        }
        model.addObject("metaTag", metaTag);
        return model;
    }
}