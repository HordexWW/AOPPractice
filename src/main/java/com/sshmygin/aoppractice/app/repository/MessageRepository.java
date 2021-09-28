package com.sshmygin.aoppractice.app.repository;

import com.sshmygin.aoppractice.app.model.Message;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private List<Message> messages;

    @PostConstruct
    public void fillMessages() {
        this.messages = new ArrayList<>();
        messages.add(new Message(1L, "Simon", "Hi! My name is Simon"));
        messages.add(new Message(2L, "John", "Hi! My name is John"));
        messages.add(new Message(3L, "Alice", "Hi! My name is Alice"));
        messages.add(new Message(4L, "Ingvar", "Hi! My name is Ingvar"));
        messages.add(new Message(5L, "Mike", "Hi! My name is Mike"));
    }

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
        message.setId(messages.size() + 1);
        this.messages.add(message);
    }
}
