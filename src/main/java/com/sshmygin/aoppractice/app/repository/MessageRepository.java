package com.sshmygin.aoppractice.app.repository;

import com.sshmygin.aoppractice.app.model.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> findAll();

    Message findById(long id);

    void addMessage(Message message);
}
