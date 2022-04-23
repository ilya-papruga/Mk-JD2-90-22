package by.it_academy.jd2.HomeWork.messenger.core.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private LocalDateTime sendTime;
    private String sender;
    private String receiver;
    private String text;

    public Message(String receiver, String text) {
        this.receiver = receiver;
        this.text = text;
    }

    public String getSendTime() {
        return sendTime.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss"));
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
