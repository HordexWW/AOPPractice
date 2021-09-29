package com.sshmygin.aoppractice.app.repository;

import com.sshmygin.aoppractice.app.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private List<Message> messages;

    @Autowired
    private SenderRepository senderRepository;

    public List<Message> findAll() {
        return this.messages;
    }

    public Message findById(long id) {
        return messages.stream()
                .filter((message) -> message.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addMessage(Message message) {
        System.out.println("Adding messsage...");
        message.setId((long) (messages.size() + 1));
        this.messages.add(message);
    }

    @PostConstruct
    public void fillMessages() {
        this.messages = new ArrayList<>();
        addMessage(new Message(1L, senderRepository.findById(1L), "Hi! My name is Simon"));
        addMessage(new Message(2L, senderRepository.findById(2L), "Hi! My name is John"));
        addMessage(new Message(3L, senderRepository.findById(3L), "Hi! My name is Alice"));
        addMessage(new Message(4L, senderRepository.findById(4L), "Hi! My name is Ingvar"));
        addMessage(new Message(5L, senderRepository.findById(5L), "Hi! My name is Mike"));
    }
}
