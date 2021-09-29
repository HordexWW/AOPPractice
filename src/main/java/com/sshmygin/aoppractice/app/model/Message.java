package com.sshmygin.aoppractice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private Sender sender;
    private String content;

    public Message(Sender sender, String content) {
        this.sender = sender;
        this.content = content;
    }
}
