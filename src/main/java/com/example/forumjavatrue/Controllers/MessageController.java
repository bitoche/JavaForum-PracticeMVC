package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @Autowired
    private final IMessageService messageService;
    public MessageController(IMessageService messageService){
        this.messageService = messageService;
    }
    @GetMapping("/messages")
    public String gotoMessages(Model model){
        model.addAttribute("messages", messageService.ListMessages());
        return "messages";
    }
}
