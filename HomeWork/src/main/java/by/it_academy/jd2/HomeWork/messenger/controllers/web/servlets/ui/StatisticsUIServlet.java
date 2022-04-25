package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets.ui;

import by.it_academy.jd2.HomeWork.messenger.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsUIServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsUIServlet extends HttpServlet {

    private StatisticsService service;

    public StatisticsUIServlet() {
        this.service = StatisticsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");

        req.setAttribute("sessions", service.getSessionsCount());
        req.setAttribute("users", service.getUsersCount());
        req.setAttribute("messages", service.getMesagesCount());

        req.getRequestDispatcher("/ui/admin/Statistics.jsp").forward(req, resp);
    }
}