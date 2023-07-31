package com.anhnbt.blog.controller;

import com.anhnbt.blog.exception.PostNotFoundException;
import com.anhnbt.blog.model.MetaTag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    protected ModelAndView handleNotFoundException(PostNotFoundException e, WebRequest request) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("404 Not Found - Bài viết không tồn tại");
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("metaTag", metaTag);
        return modelAndView;
    }
}