package com.sshmygin.aoppractice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private long id;
    private String senderName;
    private String content;

    public Message(String senderName, String content) {
        this.senderName = senderName;
        this.content = content;
    }
}
