package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String processLogin(User user) {
        user.setRegisterDate(new Date());
        user.setMessageCounter(0);
        userRepository.AddUser(user);
        return "redirect:/";
    }
}
