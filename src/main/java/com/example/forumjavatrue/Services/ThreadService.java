package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Repository.IThreadRepository;
import com.example.forumjavatrue.Models.Thread;
import org.springframework.stereotype.Service;

@Service
public class ThreadService implements IThreadService{
    private IThreadRepository threadRepository;
    public ThreadService(IThreadRepository threadRepository){
        this.threadRepository = threadRepository;
    }
    @Override
    public void Add(Thread thread) {
        threadRepository.Add(thread);
    }

    @Override
    public Object GetByID(long id) {
        return threadRepository.GetByID(id);
    }

    @Override
    public Object ListThreads() {
        return threadRepository.GetAll();
    }
}
