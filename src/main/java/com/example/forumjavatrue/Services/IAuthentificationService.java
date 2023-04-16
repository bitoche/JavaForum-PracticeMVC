package com.example.forumjavatrue.Services;

import org.springframework.stereotype.Service;

@Service
public interface IAuthentificationService {
    boolean IsUserExist(String login, String password);
}
