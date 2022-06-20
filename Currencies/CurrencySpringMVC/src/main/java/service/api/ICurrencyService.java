package service.api;

import core.dto.CurrencyDtoCreate;
import core.dto.CurrencyDtoRead;
import core.dto.CurrencyDtoUpdate;
import core.entity.Currency;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyService {

    Currency create(CurrencyDtoCreate dto);

    Currency read (Long id);

    List<Currency> readAll();

    Currency update(Long id, CurrencyDtoUpdate dto, LocalDateTime dtUpdate);

    void delete (Long id, LocalDateTime dtUpdate);

}
