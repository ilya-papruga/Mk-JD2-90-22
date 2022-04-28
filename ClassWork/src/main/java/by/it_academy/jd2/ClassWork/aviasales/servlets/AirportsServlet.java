package by.it_academy.jd2.ClassWork.aviasales.servlets;


import by.it_academy.jd2.ClassWork.aviasales.dao.Airport;
import by.it_academy.jd2.ClassWork.aviasales.dao.AirportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet (name = "Airports.servlet", urlPatterns = "/api/airports")
public class AirportsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }

        AirportDao airportDao = new AirportDao();

        List<Airport> airports = airportDao.getAll();


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        for (Airport airport : airports) {

            writer.write("<p>" + String.valueOf(airport) + "</p></br>");

        }

    }
}
