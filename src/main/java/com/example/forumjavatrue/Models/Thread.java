package com.example.forumjavatrue.Models;

public class Thread {
    private long ID;
    private String Title;
    private String Description;
    /*private Message[] Messages;*/

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
    /*public Message[] getMessages(){
        return Messages;
    }
    public void setMessages(Message[] messages){
        Messages = messages;
    }*/


    public Thread(long ID, String title, String description/*, Message[] messages*/) {
        this.ID = ID;
        Title = title;
        Description = description;
        /*Messages = messages;*/
    }

    public Thread(String title, String description/*, Message[] messages*/) {
        Title = title;
        Description = description;
/*        Messages = messages*/;
    }

    public Thread(){}
}
