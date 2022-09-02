package com.workmentor.api.controllers;

import com.workmentor.api.models.Messages;
import com.workmentor.api.services.MessagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/messages")
public class MessagesController {

    private MessagesService messagesService;

    public MessagesController( MessagesService messagesService ){
        this.messagesService = messagesService;
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping("/{id}")
    public Messages GetMessages(@PathVariable String id){
        return messagesService.GetMessageById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @GetMapping
    public List<Messages> GetAllUsers(){
        return messagesService.GetAllMessages();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PostMapping
    public Messages PostMessage(@RequestBody Messages messages){
        return messagesService.AddNewMessage(messages);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @PutMapping
    public ResponseEntity<Messages> PutMessage(@RequestBody Messages messages){
        Messages foundMessages = messagesService.GetMessageById(messages.getId().toString());
        if(foundMessages != null){
            Messages updatedMessage = messagesService.UpdateMessage(messages);
            return new ResponseEntity<>(updatedMessage, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://959037-workmentor.s3-website-us-west-2.amazonaws.com/"})
    @DeleteMapping("/delete")
    public ResponseEntity<String> DeleteMessage(@RequestBody Messages messages) {
        Messages foundMessage = messagesService.GetMessageById(messages.getId().toString());
        if (foundMessage != null) {
            messagesService.DeleteMessage(messages);
            return new ResponseEntity<>("Deleted User", HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
