package com.sshmygin.aoppractice.aspect;

import com.sshmygin.aoppractice.app.model.Message;
import com.sshmygin.aoppractice.app.model.Sender;
import com.sshmygin.aoppractice.app.repository.SenderRepository;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class BanMessageSenderAspect {

    private List<Sender> banList;

    @Autowired
    private SenderRepository senderRepository;

    @Pointcut("execution(public void com.sshmygin.aoppractice.app.service.MessageService.addMessage(..)) &&" +
            "args(message)")
    private void messageServiceAddMessageMethod(Message message) {}

    @Before(value = "messageServiceAddMessageMethod(message)", argNames = "message")
    public void doNotSendMessageFromBannedSender(Message message) {
        Sender bannedSender = banList.stream()
                .filter((sender -> sender.equals(message.getSender())))
                .findFirst()
                .orElse(null);
        if(bannedSender != null) {
            throw new IllegalStateException("Sender " + bannedSender.getName() + " is banned, message was not sent.");
        }
    }

    @PostConstruct
    private void initialiseBanList() {
        this.banList = Arrays.asList(
                senderRepository.findById(1L),
                senderRepository.findById(3L)
        );
    }

}
