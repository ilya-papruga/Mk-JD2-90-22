package org.example.service;

import org.example.core.dao.api.ICurrencyDao;
import org.example.core.dto.CurrencyDtoUpdate;
import org.example.core.entity.Currency;
import org.example.core.dto.CurrencyDtoCreate;
import org.springframework.stereotype.Service;
import org.example.service.api.ICurrencyService;
import org.example.service.api.IMapperService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {

    private final ICurrencyDao currencyDao;
    private final IMapperService mapperService;

    public CurrencyService(ICurrencyDao currencyDao, MapperService mapperService) {
        this.currencyDao = currencyDao;
        this.mapperService = mapperService;
    }

    @Override
    public Currency create(CurrencyDtoCreate dto) {

        if (dto.getName() == null || dto.getCode() == null || dto.getDescription() == null) {
            throw new IllegalArgumentException("Для создания необходимо заполнить все поля");
        }

        return this.currencyDao.save(this.mapperService.mapCreate(dto));
    }

    @Override
    public Currency read(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Поле id не может быть пустым");
        }

        return this.currencyDao
                .findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Не нашли такой валюты");
                });

    }

    @Override
    public List<Currency> readAll() {
        return this.currencyDao.findAll();
    }

    @Override
    public List<Currency> readAll(String name) {
        return this.currencyDao.findByName(name);
    }

    @Override
    public Currency update(Long id, CurrencyDtoUpdate dto, LocalDateTime dtUpdate) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Поле id не может быть пустым");
        }

        Currency currency = this.read(id);

        if (!currency.getDtUpdate().equals(dtUpdate)) {
            throw new IllegalArgumentException("Валюта уже была обновлена кем-то ранее");
        }

        currency.setCode(dto.getCode());
        currency.setDescription(dto.getDescription());
        currency.setName(dto.getName());

        this.currencyDao.save(currency);

        return this.read(id);

    }
/*
    public void delete (Long id, LocalDateTime dtUpdate){

        if (id == null || id <= 0){
            throw new IllegalArgumentException("Поле id не может быть пустым");
        }
        this.currencyDao.delete(id, dtUpdate);
    }

 */

}
