package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Models.Thread;
import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Services.IMessageService;
import com.example.forumjavatrue.Services.IUserService;
import com.example.forumjavatrue.Services.IThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {
    @Autowired
    private final IMessageService messageService;
    @Autowired
    private final IUserService userService;
    @Autowired
    private final IThreadService threadService;
    public MessageController(IMessageService messageService, IUserService userService, IThreadService threadService){
        this.messageService = messageService;
        this.userService = userService;
        this.threadService = threadService;
    }
    @GetMapping("/messages")
    public String gotoMessages(Model model){
        model.addAttribute("messages", messageService.ListMessages());
        return "messages";
    }
    @PostMapping("/addMessage")
    public String addMessage(Message message, String senderid, String threadid){
        message.setSender((User) userService.GetByID(Long.parseLong(senderid)));
        message.setThread((Thread) threadService.GetByID(Long.parseLong(threadid)));
        messageService.Add(message);
        return "redirect:/messages";
    }
}
