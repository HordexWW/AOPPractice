package com.sshmygin.aoppractice.app.repository;

import com.sshmygin.aoppractice.app.model.Sender;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SenderRepositoryImpl implements SenderRepository {

    private List<Sender> senderList;

    @Override
    public List<Sender> findAll() {
        return this.senderList;
    }

    @Override
    public Sender findById(long id) {
        return this.senderList.stream()
                .filter((sender) -> sender.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addSender(Sender sender) {
        sender.setId((long) (senderList.size() + 1));
        this.senderList.add(sender);
    }

    @PostConstruct
    private void initializeSenderList() {
        this.senderList = new ArrayList<>();
        addSender(new Sender("Simon"));
        addSender(new Sender("John"));
        addSender(new Sender("Alice"));
        addSender(new Sender("Ingvar"));
        addSender(new Sender("Mike"));
    }
}
