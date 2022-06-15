package service;

import core.dao.CurrencyDao;
import core.dao.api.ICurrencyDao;
import core.entity.Currency;
import core.dto.CurrencyDtoCU;
import service.api.ICurrencyService;

import java.time.LocalDateTime;
import java.util.List;

public class CurrencyService implements ICurrencyService {

    
    private final ICurrencyDao currencyDao;
    
    public CurrencyService(ICurrencyDao currencyDao) {this.currencyDao = currencyDao;}

    public void create(CurrencyDtoCU dto){
        this.currencyDao.create(map(dto));
    }

    public Currency read (long id){

        return this.currencyDao.read(id);

    }

    public List<Currency> readAll()
    {

        return this.currencyDao.readAll();
    }

    public void update(long id, CurrencyDtoCU dto){
        this.currencyDao.update(id, map(dto));
    }

    public void delete (long id){

        this.currencyDao.delete(id);

    }


    public Currency map (CurrencyDtoCU dto){

        Currency currency = new Currency();

        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(LocalDateTime.now());
        currency.setName(dto.getName());
        currency.setDescription(dto.getDescription());
        currency.setCode(dto.getCode());
        return currency;
    }
    
    
}
