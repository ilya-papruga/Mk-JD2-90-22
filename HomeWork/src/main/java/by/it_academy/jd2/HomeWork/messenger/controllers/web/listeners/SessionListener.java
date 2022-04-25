package by.it_academy.jd2.HomeWork.messenger.controllers.web.listeners;


import by.it_academy.jd2.HomeWork.messenger.service.StatisticsService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionAttributeListener {

    private StatisticsService service;

    public SessionListener() {
        this.service = StatisticsService.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

                service.incSessionCount();
                System.out.println("Dobavlen aktivniy polzovatel");

        }


    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

}
