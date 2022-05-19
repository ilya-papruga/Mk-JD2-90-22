package by.it_academy.jd2.HomeWork.aviasales.service;

import by.it_academy.jd2.HomeWork.aviasales.dao.Airport;
import by.it_academy.jd2.HomeWork.aviasales.dao.AirportDao;
import by.it_academy.jd2.HomeWork.aviasales.dao.IAirportDao;

import java.util.List;

public class AirportService {

    private static final AirportService instance = new AirportService();

    private final IAirportDao dao;


    private AirportService() {
        this.dao = AirportDao.getInstance();
    }

    public List<Airport> getAll (){
        return this.dao.getAll();
    }

    public static AirportService getInstance() {
        return instance;
    }

}
