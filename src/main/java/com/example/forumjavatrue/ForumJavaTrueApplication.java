package com.example.forumjavatrue;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.IUserRepository;
import com.example.forumjavatrue.Repository.UserRepository;
import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ForumJavaTrueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumJavaTrueApplication.class, args);
        
    }
}
