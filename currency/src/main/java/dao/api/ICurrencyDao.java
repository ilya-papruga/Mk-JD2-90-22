package dao.api;

import core.entity.Currency;

import java.util.List;

public interface ICurrencyDao {

    /**
     * создать новую валюту
     * @param currency валюта
     */
    public void create(Currency currency);

    /**
     * получить карточку валюты
     * @param id id валюты
     */
    public Currency read (long id);

    /**
     * получить лист валюты
     */
    public List<Currency> readAll();

    /**
     * обновить запись валюты
     * @param id id обновляемой валюты
     * @param currencyUpdater новая информация
     */

    public void update(long id, Currency currencyUpdater);

    /**
     * удалить валюту
     * @param id id удаляемой валюты
     */
    public void delete(long id);

}
