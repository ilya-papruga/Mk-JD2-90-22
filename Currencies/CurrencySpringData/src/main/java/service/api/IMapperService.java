package service.api;

import core.dto.CurrencyDtoCreate;
import core.dto.CurrencyDtoRead;
import core.dto.CurrencyDtoUpdate;
import core.entity.Currency;
import org.springframework.stereotype.Service;


public interface IMapperService {

    CurrencyDtoRead mapRead(Currency currency);

    Currency mapCreate (CurrencyDtoCreate dto);

    Currency mapUpdate (CurrencyDtoUpdate dto);

}
