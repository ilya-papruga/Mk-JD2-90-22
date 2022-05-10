package by.it_academy.jd2.HomeWork.aviasales.servlets.ui;


import by.it_academy.jd2.HomeWork.aviasales.dao.Airport;
import by.it_academy.jd2.HomeWork.aviasales.dao.AirportDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
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


        req.setAttribute("allAirports", airports);

        req.getRequestDispatcher("airports.jsp").forward(req, resp);

    }


}
