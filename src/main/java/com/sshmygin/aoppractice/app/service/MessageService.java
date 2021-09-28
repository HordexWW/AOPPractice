package com.sshmygin.aoppractice.app.service;

import com.sshmygin.aoppractice.app.model.Message;
import com.sshmygin.aoppractice.app.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Autowired
    private final MessageRepository messageRepository;

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public Message getMessageById(long id) {
        return messageRepository.findById(id);
    }

    public void addMessage(Message message){
        messageRepository.addMessage(message);
    }
}
