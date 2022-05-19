package by.it_academy.jd2.HomeWork.aviasales.controllers.json;


import by.it_academy.jd2.HomeWork.aviasales.dao.Airport;
import by.it_academy.jd2.HomeWork.aviasales.dao.AirportDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AirportsServletJson", urlPatterns = "/json/aviasales/airports")
public class AirportsServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

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
        resp.setContentType("application/json; charset=utf-8");


        req.setAttribute("allAirports", airports);

       // req.getRequestDispatcher("airports.jsp").forward(req, resp);

        String json = mapper.writeValueAsString(airports);

        PrintWriter writer = resp.getWriter();
        writer.write(json);
    }


}
