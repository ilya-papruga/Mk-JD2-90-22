package core.dao.api;

import core.entity.Currency;

import java.time.LocalDateTime;
import java.util.List;

public interface ICurrencyDao {

    /**
     * создать новую валюту
     * @param currency валюта
     */
    public Currency create(Currency currency);

    /**
     * получить карточку валюты
     * @param id id валюты
     */
    public Currency read (Long id);

    /**
     * получить лист валют
     */
    public List<Currency> readAll();

    /**
     * обновить запись валюты
     *
     * @param id id обновляемой валюты
     * @param currencyUpdater новая информация
     * @param dtUpdate дата последнего обновления записи
     */

    public void update(Long id, Currency currencyUpdater, LocalDateTime dtUpdate);

    /**
     * удалить валюту
     * @param id id удаляемой валюты
     * @param dtUpdate дата последнего обновления валюты
     */
    public void delete(Long id, LocalDateTime dtUpdate);

}
