package com.scorenoscore.springserver.controller;

import com.scorenoscore.springserver.model.message.Message;
import com.scorenoscore.springserver.model.message.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/messages/get-all")
    public List<Message> getAllMessages(){
          return messageDAO.getAllMessages();
    }

    @PostMapping("/message/save")
    public void save(@RequestBody Message message){
        messageDAO.save(message);
    }
}
