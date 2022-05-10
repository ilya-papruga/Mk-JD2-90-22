package by.it_academy.jd2.HomeWork.aviasales.service;

import by.it_academy.jd2.HomeWork.aviasales.dao.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsService {

    private static final FlightsService instance = new FlightsService();

    private List<Flight> savedFlight = new ArrayList<>();

    public void save(Flight flight) {
        savedFlight.add(flight);
    }

    public Flight getSavedFlight() {

        return savedFlight.get(0);
    }

    public static FlightsService getInstance() {
        return instance;
    }

}
