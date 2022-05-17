package by.it_academy.jd2.HomeWork.aviasales.servlets.ui;


import by.it_academy.jd2.HomeWork.aviasales.dao.Airport;
import by.it_academy.jd2.HomeWork.aviasales.dao.AirportDao;
import by.it_academy.jd2.HomeWork.aviasales.dao.Flight;
import by.it_academy.jd2.HomeWork.aviasales.dao.FlightDao;
import by.it_academy.jd2.HomeWork.aviasales.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FlightsServlet", urlPatterns = "/aviasales/flights")
public class FlightsServlet extends HttpServlet {

    private FlightsService service;

    public FlightsServlet() {
        this.service = FlightsService.getInstance();
    }

    private List<Flight> savedFlight = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }

        AirportDao airportDao = new AirportDao();
        FlightDao flightDao = new FlightDao();

        List<Airport> airports = airportDao.getAll();


        if (!savedFlight.isEmpty()) {
            List<Flight> flights = flightDao.get(getSavedFlight().get(0));
            req.setAttribute("searchFlights", flights);
        }


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");


        req.setAttribute("allAirports", airports);

        req.getRequestDispatcher("/jsp/aviasales/flights.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String scheduled_departure_local = req.getParameter("scheduled_departure_local");
        String departure_airport_name = req.getParameter("departure_airport_name");
        String scheduled_arrival_local = req.getParameter("scheduled_arrival_local");
        String arrival_airport_name = req.getParameter("arrival_airport_name");

        Flight flight = new Flight(scheduled_departure_local, departure_airport_name, scheduled_arrival_local, arrival_airport_name);

        saveFlight(flight);

    }

    public void saveFlight(Flight flight) {
        savedFlight.add(flight);
    }

    public List<Flight> getSavedFlight() {
        return savedFlight;
    }

}
