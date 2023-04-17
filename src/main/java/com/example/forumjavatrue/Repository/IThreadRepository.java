package com.example.forumjavatrue.Repository;

import com.example.forumjavatrue.Models.Thread;

import java.util.List;

public interface IThreadRepository {
    void Add(Thread thread);
    void DeleteByID(long id);
    Thread GetByID(long id);
    List<Thread> GetAll();
}
