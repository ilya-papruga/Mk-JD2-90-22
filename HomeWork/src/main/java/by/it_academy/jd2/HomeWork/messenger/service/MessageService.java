package by.it_academy.jd2.HomeWork.messenger.service;

import by.it_academy.jd2.HomeWork.messenger.core.dto.Message;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MessageService {

    private static final MessageService instance = new MessageService();

    private StatisticsService service;

    public MessageService() {
        this.service = StatisticsService.getInstance();
    }

    List<Message> SavedMessages = new ArrayList<>();

    public void send(Message message, String session) {
        message.setSender(session);
        message.setSendTime(LocalDateTime.now());
        SavedMessages.add(message);
        service.incMessagesCount();
    }

    public List<Message> getSavedMessages() {
        return SavedMessages;
    }

    public static MessageService getInstance() {
        return instance;
    }
}
