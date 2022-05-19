package by.it_academy.jd2.HomeWork.aviasales.controllers.html;

import by.it_academy.jd2.HomeWork.aviasales.service.AirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirportsServlet", urlPatterns = "/aviasales/airports")
public class AirportsServlet extends HttpServlet {

    private final AirportService airportsService;

    public AirportsServlet() {
        this.airportsService = AirportService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        req.setAttribute("airports", this.airportsService.getAll());

        req.getRequestDispatcher("/jsp/aviasales/airports.jsp").forward(req, resp);

    }

}
