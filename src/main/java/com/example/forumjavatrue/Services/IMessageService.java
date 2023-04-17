package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Repository.IMessageRepository;
import org.springframework.stereotype.Service;

@Service
public interface IMessageService {
    void Add(Message message);

    boolean CheckMessage(long id);

    void DeleteByID(long id);

    Object GetByID(long id);
    Object ListMessages();
}
