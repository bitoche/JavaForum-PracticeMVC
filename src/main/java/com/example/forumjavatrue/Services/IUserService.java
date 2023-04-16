package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void AddUser(User user);
    public Object GetByID(long id);
    public Object GetByUsername(String username);
    Object ListUsers();
    boolean CheckUser(long id);
}
