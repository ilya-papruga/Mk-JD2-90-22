package org.example.service.api;

import org.example.core.dto.CurrencyDtoCreate;
import org.example.core.dto.CurrencyDtoRead;
import org.example.core.dto.CurrencyDtoUpdate;
import org.example.core.entity.Currency;


public interface IMapperService {

    CurrencyDtoRead mapRead(Currency currency);

    Currency mapCreate (CurrencyDtoCreate dto);

    Currency mapUpdate (CurrencyDtoUpdate dto);

}
