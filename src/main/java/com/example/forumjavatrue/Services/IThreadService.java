package com.example.forumjavatrue.Services;

import com.example.forumjavatrue.Models.Thread;
import org.springframework.stereotype.Service;

@Service
public interface IThreadService {
    void Add(Thread thread);

    boolean CheckThread(long id);

    void DeleteById(long id);

    Object GetByID(long id);
    Object ListThreads();

}
