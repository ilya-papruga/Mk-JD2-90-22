package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets.api;

import by.it_academy.jd2.HomeWork.messenger.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private StatisticsService service;

    public StatisticsServlet() {
        this.service = StatisticsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<p>" + "Количество активных сессий: " + service.getSessionsCount() + "</p></br>");
        writer.write("<p>" + "Количество пользвателей: " + service.getUsersCount() + "</p></br>");
        writer.write("<p>" + "Количество отправленных сообщений: " + service.getMesagesCount() + "</p></br>");

    }
}
