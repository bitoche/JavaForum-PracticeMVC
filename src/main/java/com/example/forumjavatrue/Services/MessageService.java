package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.Message;
import com.example.forumjavatrue.Repository.IMessageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService implements IMessageService {

    private IMessageRepository messageRepository;

    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void Add(Message message) {
        message.setSendDate(new Date());
        messageRepository.Add(message);
    }
    @Override
    public boolean CheckMessage(long id){
        if(messageRepository.GetByID(id)==null){
            return false;
        }
        return true;
    }
    @Override
    public void DeleteByID(long id) {
        messageRepository.DeleteByID(id);
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
