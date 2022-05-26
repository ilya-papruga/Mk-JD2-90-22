package by.it_academy.jd2.University.service;

import by.it_academy.jd2.University.dao.CrossDao;
import by.it_academy.jd2.University.dto.CrossDto;
import by.it_academy.jd2.University.dto.CrossDtoGet;

import java.util.List;

public class CrossService {

    private static final CrossService instance = new CrossService();

    private final CrossDao dao;

    public CrossService() {
        this.dao = CrossDao.getInstance();
    }

    public List<CrossDtoGet> readAll(){
        return this.dao.readAll();
    }

    public void create(CrossDto cross){
        this.dao.create(cross);
    }

    public void delete(CrossDto cross){
        this.dao.delete(cross);
    }


    public static CrossService getInstance() {
        return instance;
    }
}
