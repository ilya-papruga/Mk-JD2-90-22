package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets;

import by.it_academy.jd2.HomeWork.messenger.core.dto.Message;
import by.it_academy.jd2.HomeWork.messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ChatsServlet", urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    private MessageService service;

    public ChatsServlet() {
        this.service = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String user = (String) req.getSession().getAttribute("user");
        String contextPath = req.getContextPath();

        List<String> chatMessages = new ArrayList<>();

        for (Message message : service.getSavedMessages()) {
            if (message.getReceiver().equals(user)) {
                chatMessages.add(
                        message.getSendTime() + " "
                                + message.getSender() + " "
                                + message.getText());
            }
        }

        if (user == null) {
            resp.sendRedirect(contextPath + "/ui/SignIn");
        } else {
            req.setAttribute("messages", chatMessages);
            req.getRequestDispatcher("/ui/user/Chats.jsp").forward(req, resp);

        }
    }
}
