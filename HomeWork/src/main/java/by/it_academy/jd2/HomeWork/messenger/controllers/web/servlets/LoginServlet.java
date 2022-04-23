package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets;

import by.it_academy.jd2.HomeWork.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private UserService service;

    public LoginServlet() {
        this.service = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();

        if (service.check(login, password)) {
            session.setAttribute("user", login);
        } else {
            writer.write("Ошибка ввода логина/пароля");
        }

        // writer.write((String) session.getAttribute("user"));


    }
}
