package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.IUserRepository;
import com.example.forumjavatrue.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String processRegistration(User user) {
        user.setRegisterDate(new Date());
        user.setMessageCounter(0);
        userService.AddUser(user);
        return "redirect:/";
    }
}
