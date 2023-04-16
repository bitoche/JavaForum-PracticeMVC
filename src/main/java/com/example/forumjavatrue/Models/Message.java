package com.example.forumjavatrue.Models;

import java.util.Date;
public class Message {
    private long ID;
    private String Content;
    private User Sender;
    private Thread Thread;
    private Date SendDate;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public User getSender() {
        return Sender;
    }

    public void setSender(User sender) {
        Sender = sender;
    }

    public Thread getThread() {
        return Thread;
    }

    public void setThread(Thread thread) {
        Thread = thread;
    }

    public Date getSendDate() {
        return SendDate;
    }

    public void setSendDate(Date sendDate) {
        SendDate = sendDate;
    }

    public Message(long ID, String content, User sender, Thread thread) { //если создаем новое
        this.ID = ID;
        Content = content;
        Sender = sender;
        Thread = thread;
        SendDate = new Date();
    }

    public Message(long ID, String content, User sender, com.example.forumjavatrue.Models.Thread thread, Date sendDate) {
        this.ID = ID;
        Content = content;
        Sender = sender;
        Thread = thread;
        SendDate = sendDate;
    }

    public Message(String content, User sender, com.example.forumjavatrue.Models.Thread thread, Date sendDate) {
        Content = content;
        Sender = sender;
        Thread = thread;
        SendDate = sendDate;
    }

    public Message(){}
}
