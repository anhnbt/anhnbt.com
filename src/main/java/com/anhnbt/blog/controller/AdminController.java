package com.anhnbt.blog.controller;

import com.anhnbt.blog.common.Constants;
import com.anhnbt.blog.model.MetaTag;
import com.anhnbt.blog.model.NicknameDto;
import com.anhnbt.blog.service.CategoryService;
import com.anhnbt.blog.service.NicknameService;
import com.anhnbt.blog.util.WebUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private NicknameService nicknameService;

    @Autowired
    private CategoryService categoryService;

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @ModelAttribute
    public void categoriesAttributes(Model model) {
        model.addAttribute("categories", categoryService.findAll());
    }

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/nicknames")
    public ModelAndView list(@PageableDefault(size = 20) @SortDefault.SortDefaults({@SortDefault(sort = "id", direction = Sort.Direction.DESC)}) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("admin/nickname/list");
        modelAndView.addObject("nicknames", nicknameService.findAll(pageable));
        modelAndView.addObject("metaTag", new MetaTag(WebUtils.getMessage("nickname.list.headline")));
        return modelAndView;
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/nicknames/add")
    public String add(@ModelAttribute("nickname") NicknameDto nicknameDto) {
        return "admin/nickname/add";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/nicknames/add")
    public String add(@Validated @ModelAttribute("nickname") NicknameDto nicknameDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                return "admin/nickname/add";
            }
            nicknameService.create(nicknameDto);
            redirectAttributes.addFlashAttribute(Constants.MSG_SUCCESS, WebUtils.getMessage("nickname.create.success"));
        } catch (Exception e) {
            logger.debug("Exception when /admin/nicknames/add", e);
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Thêm tên không thành công!");
        }
        return "redirect:/admin/nicknames";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @GetMapping("/nicknames/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("nickname", nicknameService.findById(id));
        model.addAttribute("metaTag", new MetaTag(WebUtils.getMessage("nickname.edit.headline")));
        return "admin/nickname/edit";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/nicknames/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute("nickname") NicknameDto nicknameDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        try {
            if (bindingResult.hasErrors()) {
                return "admin/nicknames/edit";
            }
            nicknameService.update(id, nicknameDto);
            redirectAttributes.addFlashAttribute(Constants.MSG_SUCCESS, WebUtils.getMessage("nickname.update.success"));
        } catch (Exception e) {
            logger.debug("Exception when /admin/nicknames/edit/{0}: {1}", id, e);
            redirectAttributes.addFlashAttribute(Constants.MSG_ERROR, "Chỉnh sửa tên không thành công!");
        }
        return "redirect:/admin/nicknames";
    }

    @Secured(Constants.Roles.ROLE_ADMIN)
    @PostMapping("/nicknames/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        nicknameService.delete(id);
        redirectAttributes.addFlashAttribute(Constants.MSG_INFO, WebUtils.getMessage("nickname.delete.success"));
        return "redirect:/admin/nicknames";
    }
}
