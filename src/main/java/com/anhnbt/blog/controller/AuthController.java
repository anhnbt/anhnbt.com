package com.anhnbt.blog.controller;

import com.anhnbt.blog.common.Constants;
import com.anhnbt.blog.exception.EmailExistsException;
import com.anhnbt.blog.exception.UsernameExistsException;
import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.model.UserDto;
import com.anhnbt.blog.repository.RoleRepository;
import com.anhnbt.blog.service.UserService;
import com.anhnbt.blog.validator.RegisterValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RegisterValidator registerValidator;

    @GetMapping("/login")
    public String login(Model model, Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/";
        }
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Đăng nhập - anhnbt.com");
        metaTag.setDescription("Đăng nhập tài khoản blog anhnbt.com");
        model.addAttribute("metaTag", metaTag);
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        MetaTag metaTag = new MetaTag();
        metaTag.setTitle("Đăng ký - anhnbt.com");
        metaTag.setDescription("Đăng ký tài khoản blog anhnbt.com");
        model.addAttribute("metaTag", metaTag);
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute("user") UserDto accountDto,
                         BindingResult result,
                         RedirectAttributes redirect) {
        try {
            registerValidator.validate(accountDto, result);
            if (result.hasErrors()) {
                MetaTag metaTag = new MetaTag();
                metaTag.setTitle("Đăng ký - anhnbt.com");
                metaTag.setDescription("Đăng ký tài khoản blog anhnbt.com");
                return "signup";
            }
            accountDto.setRoles(List.of(roleRepository.findByName(Constants.Roles.ROLE_USER)));
            userService.save(accountDto);
            redirect.addFlashAttribute(Constants.MSG_SUCCESS, "Đăng ký tài khoản thành công!");
        } catch (EmailExistsException | UsernameExistsException e) {
            log.error("Exception when /signup", e);
            redirect.addFlashAttribute(Constants.MSG_ERROR, "Email hoặc username đã được sử dụng!");
        }
        return "redirect:/login";
    }
}