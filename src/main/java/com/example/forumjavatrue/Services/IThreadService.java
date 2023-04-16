package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.Thread;
import org.springframework.stereotype.Service;

@Service
public interface IThreadService {
    void Add(Thread thread);

    Object GetByID(long id);
    Object ListThreads();

}
