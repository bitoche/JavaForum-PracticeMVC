package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.DateHelper;
import com.example.forumjavatrue.Services.IUserService;
import com.example.forumjavatrue.Services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String gotoMain(@NotNull Model model) {
        model.addAttribute("users", userService.ListUsers());
        return "/main";
    }

    @GetMapping("/addUser/")
    public String gotoUsers(Model model) {
        model.addAttribute("users", userService.ListUsers());
        return "users";
    }

    @PostMapping("/createUser")
    public String createUser(User user) {
        var newUser = new User(user.getUsername(), user.getLogin(), new Date(), 0, user.getPassword());
        userService.AddUser(newUser);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String gotoUserInfo(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.GetByID(id));
        return "userinfo";
    }

    @GetMapping("/user/s/{id}")
    public String gotoUserInfoFromSearch(long id, Model model) {
        if (userService.CheckUser(id)) {
            model.addAttribute("user", userService.GetByID(id));
            return "userinfo";
        }
        return gotoMain(model);
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(long id) {
        System.out.println("//log Успешно сработал метод deleteUser в UserController");
        if(userService.CheckUser(id)){
            System.out.println("//log Найден пользователь с ID=" + id);
            userService.DeleteByID(id);
        }
        return "redirect:/";
    }
}
