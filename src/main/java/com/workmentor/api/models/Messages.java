package com.workmentor.api.models;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sender;
    private String receiver;
    private String timeSent;
    private String message;

    public Messages() {}

    public Messages(Integer id, String sender, String receiver, String timeSent, String message) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.timeSent = timeSent;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
