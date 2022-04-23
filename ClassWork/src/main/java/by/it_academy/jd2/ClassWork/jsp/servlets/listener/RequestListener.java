package by.it_academy.jd2.ClassWork.jsp.servlets.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {


        System.out.println("Prishel novy zapros");



    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
