package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.Message;

import java.util.List;

public interface IMessageRepository {
    void Add(Message message);
    Message GetByID(long id);
    List<Message> GetAll();
}
