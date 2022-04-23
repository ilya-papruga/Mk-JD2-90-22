package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets;


import by.it_academy.jd2.HomeWork.messenger.core.dto.Message;
import by.it_academy.jd2.HomeWork.messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {


    private MessageService service = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();


        for (Message message : service.getSavedMessages()) {

            if (message.getReceiver().equals((String)session.getAttribute("user"))) {
                writer.write("<p>" + "Отправлено: " + message.getSendTime() + "</p></br>");
                writer.write("<p>" + "Отправитель:" + message.getSender() + "</p></br>");
                writer.write("<p>" + "Получатель:" + message.getReceiver() + "</p></br>");
                writer.write("<p>" + "Сообщение: " + message.getText() + "</p></br>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");
        HttpSession session = req.getSession();

        String receiver = req.getParameter("receiver");
        String text = req.getParameter("text");

        Message message = new Message(receiver, text);


        service.send(message, ((String)session.getAttribute("user")));

    }
}
