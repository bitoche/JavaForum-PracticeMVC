package com.example.forumjavatrue.Controllers;

import com.example.forumjavatrue.Services.IMessageService;
import com.example.forumjavatrue.Services.IThreadService;
import com.example.forumjavatrue.Services.IUserService;
import com.example.forumjavatrue.Models.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThreadController {
    @Autowired
    private final IMessageService messageService;
    @Autowired
    private final IUserService userService;
    @Autowired
    private final IThreadService threadService;

    public ThreadController(IThreadService threadService, IMessageService messageService, IUserService userService){
        this.threadService = threadService;
        this.messageService = messageService;
        this.userService = userService;
    }
    @GetMapping("/threads")
    public String gotoThreads(Model model){
        model.addAttribute("threads", threadService.ListThreads());
        return "threads";
    }

    @PostMapping("/addThread")
    public String addThread(Thread thread){
        threadService.Add(thread);
        return "redirect:/threads";
    }
    @GetMapping("/thread/{id}")
    public String gotoThreadInfo(@PathVariable long id, Model model){
        model.addAttribute("thread", threadService.GetByID(id));
        return "threadinfo";
    }
    @PostMapping("/thread/{id}/delete")
    public String deleteThread(long id) {
        System.out.println("log//<ThreadController> Успешно сработал метод deleteThread");
        if(threadService.CheckThread(id)){
            System.out.println("log//<ThreadController>\t Найден thread с ID=" + id);
            threadService.DeleteById(id);
        }
        return "redirect:/";
    }
}
