package by.it_academy.jd2.HomeWork.aviasales.service;

import by.it_academy.jd2.HomeWork.aviasales.dao.*;

import java.util.ArrayList;
import java.util.List;

public class FlightsService {

    private static final FlightsService instance = new FlightsService();

    private final IFlightsDao dao;

    private FlightsService() {
        this.dao = FlightsDao.getInstance();
    }

    public List<Flights> list (FlightsFilter filter, Pageable pageable){
        return this.dao.list(filter,pageable);
    }

    public long count (FlightsFilter filter){
        return this.dao.count(filter);
    }

    public static FlightsService getInstance() {
        return instance;
    }

}
