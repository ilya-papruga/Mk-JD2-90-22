package service.api;

import core.dto.CurrencyDtoCU;
import core.entity.Currency;

import java.util.List;

public interface ICurrencyService {

    void create(CurrencyDtoCU dto);

    Currency read (long id);

    List<Currency> readAll();

    void update(long id, CurrencyDtoCU dto);

    void delete (long id);

    Currency map (CurrencyDtoCU dto);

}
