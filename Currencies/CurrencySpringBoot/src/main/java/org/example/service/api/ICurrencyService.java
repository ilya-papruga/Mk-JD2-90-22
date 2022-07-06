package org.example.service.api;

import org.example.core.dto.CurrencyDtoCreate;
import org.example.core.dto.CurrencyDtoUpdate;
import org.example.core.entity.Currency;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyService {

    Currency create(CurrencyDtoCreate dto);

    Currency read (Long id);

    List<Currency> readAll();

    List<Currency> readAll(String name);

    Currency update(Long id, CurrencyDtoUpdate dto, LocalDateTime dtUpdate);

  //  void delete (Long id, LocalDateTime dtUpdate);

}
