package service;

import dao.CurrencyDao;
import core.entity.Currency;
import core.dto.CurrencyDtoCU;

import java.time.LocalDateTime;
import java.util.List;

public class CurrencyService {
    
    private static final CurrencyService instance = new CurrencyService();
    
    private final CurrencyDao dao;
    
    public CurrencyService() {this.dao = CurrencyDao.getInstance();}
    
    
    public void create(CurrencyDtoCU dto){
        this.dao.create(map(dto));
    }

    public Currency read (long id){

        return this.dao.read(id);

    }

    public List<Currency> readAll()
    {

        return this.dao.readAll();
    }

    public void update(long id, CurrencyDtoCU dto){
        this.dao.update(id, map(dto));
    }

    public void delete (long id){

        this.dao.delete(id);

    }


    private Currency map (CurrencyDtoCU dto){

        Currency currency = new Currency();

        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(LocalDateTime.now());
        currency.setName(dto.getName());
        currency.setDescription(dto.getDescription());
        currency.setCode(dto.getCode());
        return currency;
    }

    public static CurrencyService getInstance() {
        return instance;
    }
    
    
}
