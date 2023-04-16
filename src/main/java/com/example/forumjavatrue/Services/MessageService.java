package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService{

    private IMessageRepository messageRepository;
    public MessageService(IMessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public void Add(Message message) {
        messageRepository.Add(message);
    }

    @Override
    public Object GetByID(long id) {
        return messageRepository.GetByID(id);
    }

    @Override
    public Object ListMessages() {
        return messageRepository.GetAll();
    }
}
