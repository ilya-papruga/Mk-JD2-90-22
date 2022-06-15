package service;

import core.dto.CurrencyDtoR;
import core.entity.Currency;
import service.api.IMapperService;

public class MapperService implements IMapperService {

    public CurrencyDtoR mapRead(Currency currency) {

        CurrencyDtoR currencyDtoR = new CurrencyDtoR();

        currencyDtoR.setId(currency.getId());
        currencyDtoR.setDtCreate(currency.getDtCreate());
        currencyDtoR.setDtUpdate(currency.getDtUpdate());
        currencyDtoR.setName(currency.getName());
        currencyDtoR.setDescription(currency.getDescription());
        currencyDtoR.setCode(currency.getCode());
        return currencyDtoR;
    }

}
