package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.User;

import java.util.List;

public interface IUserRepository {
    /*long getNextUserId();*/
    void AddUser(User user);
    User GetByID(long id);
    User GetByLogin(String login);

    User GetByUsername(String username);

    List<User> GetAll();
    void DeleteByID(long id);
}
