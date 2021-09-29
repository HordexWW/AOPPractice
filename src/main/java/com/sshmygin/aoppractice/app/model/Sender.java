package com.sshmygin.aoppractice.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sender {
    private Long id;
    private String name;

    public Sender(String name) {
        this.name = name;
    }
}
