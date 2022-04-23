package by.it_academy.jd2.HomeWork.messenger.controllers.web.listeners;


import by.it_academy.jd2.HomeWork.messenger.service.StatisticsService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {

    private StatisticsService service;

    public SessionListener() {
        this.service = StatisticsService.getInstance();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Sozdana novaya sessia");
        service.incSessionCount();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
