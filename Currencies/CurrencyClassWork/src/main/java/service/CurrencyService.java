package service;

import dao.api.ICurrencyDao;
import dao.entity.Currency;
import org.springframework.stereotype.Service;
import service.api.ICurrencyService;
import dto.CurrencyCreate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {
    private final ICurrencyDao currencyDao;

    public CurrencyService(ICurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public Currency add(CurrencyCreate currencyCreate) {

        if (currencyCreate.getName() == null || currencyCreate.getCode() == null) {
            throw new IllegalArgumentException("This field cannot be empty");
        }

        Currency currency = new Currency();
        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(currency.getDtCreate());
        currency.setCode(currencyCreate.getCode());
        currency.setDescription(currencyCreate.getDescription());
        currency.setName(currencyCreate.getName());

        return this.currencyDao.add(currency);
    }


    @Override
    public void update(CurrencyCreate currencyCreate, Long id, LocalDateTime dtUpdate) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("This field cannot be null");
        }

        Currency currency = new Currency();
        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(currency.getDtCreate());
        currency.setCode(currencyCreate.getCode());
        currency.setDescription(currencyCreate.getDescription());
        currency.setName(currencyCreate.getName());

        this.currencyDao.update(currency, id, dtUpdate);
    }

    @Override
    public Currency get(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("This field cannot be null");
        }

        return this.currencyDao.get(id);
    }

    @Override
    public List<Currency> getAll() {
        return this.currencyDao.getAll();
    }
}
