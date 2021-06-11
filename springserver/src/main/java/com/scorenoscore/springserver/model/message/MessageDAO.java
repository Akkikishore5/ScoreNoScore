package com.scorenoscore.springserver.model.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageDAO {

    @Autowired
    private MessageRepository repository;

    public Message save(Message message){
        return repository.save(message);
    }

    public List<Message> getAllMessages(){
        List<Message> messages = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(messages::add);
        return messages;
    }

    public void delete(Message message){
        repository.delete(message);
    }
}
