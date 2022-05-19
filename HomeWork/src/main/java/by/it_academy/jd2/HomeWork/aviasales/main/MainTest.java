package by.it_academy.jd2.HomeWork.aviasales.main;

import by.it_academy.jd2.HomeWork.aviasales.dao.Flights;
import by.it_academy.jd2.HomeWork.aviasales.dao.FlightsDao;
import by.it_academy.jd2.HomeWork.aviasales.service.FlightsService;

import java.util.List;

public class MainTest {

    private static FlightsService service;

    public MainTest() {
        this.service = FlightsService.getInstance();
    }

    public static void main(String[] args) {


        FlightsDao flightDao = new FlightsDao();

        List<Flights> flights = flightDao.getAll();

      //  Flights flightsTest = new Flights("123", "Домодедово", "123", "arrAirport");
      //  service.save(flightsTest);


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

      //  System.out.println(service.getSavedFlight());

    }

}
