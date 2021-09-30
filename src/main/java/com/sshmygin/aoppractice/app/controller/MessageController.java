package com.sshmygin.aoppractice.app.controller;

import com.sshmygin.aoppractice.app.model.Message;
import com.sshmygin.aoppractice.app.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    @Autowired
    private final MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable(name = "id") long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public void postMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    @GetMapping("/error")
    public void throwTestException() {
        messageService.throwException();
    }
}
