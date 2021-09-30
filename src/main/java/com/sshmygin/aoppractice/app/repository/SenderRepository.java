package com.sshmygin.aoppractice.app.repository;

import com.sshmygin.aoppractice.app.model.Sender;

import java.util.List;

public interface SenderRepository {
    List<Sender> findAll();

    Sender findById(long id);

    void addSender(Sender sender);

}
