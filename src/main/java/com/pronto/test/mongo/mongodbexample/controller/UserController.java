package com.pronto.test.mongo.mongodbexample.controller;

import com.pronto.test.mongo.mongodbexample.document.User;
import com.pronto.test.mongo.mongodbexample.document.UserRegister;
import com.pronto.test.mongo.mongodbexample.service.SecurityService;
import com.pronto.test.mongo.mongodbexample.service.UserService;
import com.pronto.test.mongo.mongodbexample.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> greeting() {
        return (List<User>) userService.getAllUsers();
    }

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserRegister());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserRegister userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.create(userForm);

        securityService.autologin(userForm.username, userForm.password);
        return "redirect:/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @RequestMapping(value = {"/", "/list"},method = RequestMethod.GET)
    public String userList(Model model, Pageable pageable) {
        Page<User> pages = userService.userList(pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements",
                pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("users", pages.getContent());
        return "welcome";
    }
}


