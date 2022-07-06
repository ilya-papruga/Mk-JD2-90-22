package org.example.service;

import org.example.core.dto.CurrencyDtoCreate;
import org.example.core.dto.CurrencyDtoRead;
import org.example.core.dto.CurrencyDtoUpdate;
import org.example.core.entity.Currency;
import org.springframework.stereotype.Service;
import org.example.service.api.IMapperService;

import java.time.LocalDateTime;

@Service
public class MapperService implements IMapperService {

    public CurrencyDtoRead mapRead(Currency currency) {

        CurrencyDtoRead currencyDtoRead = new CurrencyDtoRead();

        currencyDtoRead.setId(currency.getId());
        currencyDtoRead.setDtCreate(currency.getDtCreate());
        currencyDtoRead.setDtUpdate(currency.getDtUpdate());
        currencyDtoRead.setName(currency.getName());
        currencyDtoRead.setDescription(currency.getDescription());
        currencyDtoRead.setCode(currency.getCode());
        return currencyDtoRead;
    }

    public Currency mapCreate (CurrencyDtoCreate dto){

        Currency currency = new Currency();

        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(currency.getDtCreate());
        currency.setName(dto.getName());
        currency.setDescription(dto.getDescription());
        currency.setCode(dto.getCode());
        return currency;
    }

    public Currency mapUpdate (CurrencyDtoUpdate dto){

        Currency currency = new Currency();

        currency.setName(dto.getName());
        currency.setDescription(dto.getDescription());
        currency.setCode(dto.getCode());

        return currency;
    }

}
