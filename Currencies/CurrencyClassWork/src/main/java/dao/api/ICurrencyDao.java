package dao.api;

import dao.entity.Currency;
import dto.CurrencyCreate;

import java.time.LocalDateTime;
import java.util.List;


public interface ICurrencyDao {

    List<Currency> getAll();

    Currency get(Long id);

    Currency add(Currency currency);

    void update(Currency currency, Long id, LocalDateTime dtUpdate);

    void delete(Long id, LocalDateTime dtUpdate);


}
