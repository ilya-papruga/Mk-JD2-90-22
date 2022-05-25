package by.it_academy.jd2.University.service;

import by.it_academy.jd2.University.dao.JournalDao;
import by.it_academy.jd2.University.dto.JournalDto;

import java.util.List;

public class JournalService {

     private static final JournalService instance = new JournalService();

    private final JournalDao dao;

    public JournalService() {
        this.dao = JournalDao.getInstance();
    }

    public List<JournalDto> readJournal(String groupNumber){
        return this.dao.readJournal(groupNumber);
    }

    public List<JournalDto> readAll(){
        return this.dao.readAll();
    }

    public static JournalService getInstance() {
        return instance;
    }

}
