package com.practice.controller;

import com.practice.dto.UserDTO;
import com.practice.service.RoleService;
import com.practice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());


        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

        //model.addAttribute("user", new UserDTO());  NO NEED when redirecting
        //model.addAttribute("roles", roleService.findAll());  NO NEED when redirecting

        userService.save(user);
       // model.addAttribute("users", userService.findAll());   NO NEED when redirecting

        return "redirect:/user/create";
    }
}
