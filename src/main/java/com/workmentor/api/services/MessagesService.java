package com.workmentor.api.services;

import com.workmentor.api.models.Messages;
import com.workmentor.api.repositories.MessagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {

    private MessagesRepository messagesRepository;

    public MessagesService( MessagesRepository messagesRepository){
        this.messagesRepository = messagesRepository;
    }

    public Messages AddNewMessage(Messages messages){
        return messagesRepository.save(messages);
    }

    public List<Messages> GetAllMessages(){
        return messagesRepository.findAll();
    }

    public Messages GetMessageById(String id){
        return messagesRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public Messages UpdateMessage(Messages messages){
        return messagesRepository.save(messages);
    }

    public boolean DeleteMessage(Messages messages){
        messagesRepository.delete(messages);
        return true;
    }
}
