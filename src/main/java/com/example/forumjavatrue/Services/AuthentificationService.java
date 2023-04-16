package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.User;
import com.example.forumjavatrue.Repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {
    private IUserRepository userRepository;

    public AuthentificationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean IsUserExist(String login, String password) {
        var users = userRepository.GetAll();
        for (User user : users){
            if (user.getLogin() == login && user.getPassword() == password){
                return true;
            }
        }
        return false;
    }

}
