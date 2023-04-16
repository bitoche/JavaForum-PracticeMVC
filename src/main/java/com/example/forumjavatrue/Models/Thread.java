package com.example.forumjavatrue.Models;

public class Thread {
    private long ID;
    private String Title;
    private String Description;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public Thread(long ID, String title, String description) {
        this.ID = ID;
        Title = title;
        Description = description;
    }

    public Thread(String title, String description) {
        Title = title;
        Description = description;
    }

    public Thread(){}
}
