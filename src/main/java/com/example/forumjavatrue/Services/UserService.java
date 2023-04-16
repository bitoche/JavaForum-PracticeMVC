package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.IUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private final IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.GetByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) user;
    }
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void AddUser(@NotNull User user) {
        userRepository.AddUser(user);
    }

    @Override
    public Object GetByID(long id) {
        return userRepository.GetByID(id);
    }
    @Override
    public Object GetByUsername(String username){
        return userRepository.GetByUsername(username);
    }
    @Override
    public Object ListUsers() {
        return userRepository.GetAll();
    }

    @Override
    public boolean CheckUser(long id) {
       return userRepository.GetByID(id) == null ? false : true;
    }
}

