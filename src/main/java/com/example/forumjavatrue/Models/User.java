package com.example.forumjavatrue.Models;

import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private long ID;
    private String Username;
    private String Login;
    private String Password;
    private Date RegisterDate;
    private int MessageCounter;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public Date getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(Date registerDate) {
        RegisterDate = registerDate;
    }

    public int getMessageCounter() {
        return MessageCounter;
    }

    public void setMessageCounter(int messageCounter) {
        MessageCounter = messageCounter;
    }

    public User(long ID, String username, String login, Date registerDate, int messageCounter, String password) {
        this.ID = ID;
        Username = username;
        Login = login;
        RegisterDate = registerDate;
        MessageCounter = messageCounter;
        Password = password;
    }

    public User(String username, String login, Date registerDate, int messageCounter, String password) {
        Username = username;
        Login = login;
        RegisterDate = registerDate;
        MessageCounter = messageCounter;
        Password = password;
    }

    public User(){}
}
