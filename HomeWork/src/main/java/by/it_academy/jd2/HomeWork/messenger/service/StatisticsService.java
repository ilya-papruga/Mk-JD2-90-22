package by.it_academy.jd2.HomeWork.messenger.service;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsService {

    private static final StatisticsService instance = new StatisticsService();

    public StatisticsService() {
    }

    AtomicInteger sessionsCount = new AtomicInteger(0);
    AtomicInteger usersCount = new AtomicInteger(1);
    AtomicInteger messagesCount = new AtomicInteger(0);


    public void incSessionCount() {
        this.sessionsCount.incrementAndGet();
    }

    public void decSessionCount() {
        this.sessionsCount.decrementAndGet();
    }

    public AtomicInteger getSessionsCount() {
        return sessionsCount;
    }

    public void incUsersCount() {
        this.usersCount.incrementAndGet();
    }

    public void decUsersCount() {
        this.usersCount.decrementAndGet();
    }

    public AtomicInteger getUsersCount() {
        return usersCount;
    }

    public void incMessagesCount() {
        this.messagesCount.incrementAndGet();
    }

    public void decMessagesCount() {
        this.messagesCount.decrementAndGet();
    }

    public AtomicInteger getMesagesCount() {
        return messagesCount;
    }

    public static StatisticsService getInstance() {
        return instance;
    }


}
