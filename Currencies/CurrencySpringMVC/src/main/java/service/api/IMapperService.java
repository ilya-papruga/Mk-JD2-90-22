package service.api;

import core.dto.CurrencyDtoR;
import core.entity.Currency;

public interface IMapperService {

    CurrencyDtoR mapRead(Currency currency);

}
