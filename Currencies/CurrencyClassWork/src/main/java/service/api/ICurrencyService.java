package service.api;

import dao.entity.Currency;
import dto.CurrencyCreate;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyService {
    Currency add(CurrencyCreate currencyCreate);

    void update(CurrencyCreate currencyCreate, Long id, LocalDateTime dtUpdate);

    List<Currency> getAll();

    Currency get(Long id);
}
