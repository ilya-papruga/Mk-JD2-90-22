package by.it_academy.jd2.HomeWork.aviasales.main;

import by.it_academy.jd2.HomeWork.aviasales.dao.Flight;
import by.it_academy.jd2.HomeWork.aviasales.dao.FlightDao;
import by.it_academy.jd2.HomeWork.aviasales.service.FlightsService;

import java.util.List;

public class MainTest {

    private static FlightsService service;

    public MainTest() {
        this.service = FlightsService.getInstance();
    }

    public static void main(String[] args) {


        FlightDao flightDao = new FlightDao();

        List<Flight> flights = flightDao.getAll();

        Flight flightTest = new Flight("123", "Домодедово", "123", "arrAirport");
        service.save(flightTest);


        /*
        for (Flight flight : flights) {

            System.out.println(flight);

        }
         */

/*
        List<Flight> flightsSearch = flightDao.get(flightTest);

        for (Flight search : flightsSearch) {
            System.out.println(search);

        }


 */

        System.out.println(service.getSavedFlight());

    }

}
