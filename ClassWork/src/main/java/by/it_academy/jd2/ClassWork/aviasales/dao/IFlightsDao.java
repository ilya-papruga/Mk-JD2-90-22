package by.it_academy.jd2.ClassWork.aviasales.dao;

import java.util.List;

public interface IFlightsDao extends AutoCloseable {

    /**
     * Получить все полёты
     * @return
     */
    List<Flights> getAll();



    /**
     * Получить полёты соовтествующие фильтрам
     * @param filter фильтры применяемые к запросау
     * @param pageable настройки пагинации
     * @return получившийся список с фильтрами и пагинацией
     */
    List<Flights> list(FlightsFilter filter, Pageable pageable);


    /**
     * Получить полёт
     * @param id PK полёта
     * @return
     */

    Flights get (Long id);

    /**
     * Получить количество записей соответствующих фильтрам
     * @param filter фильтры применяемые к запросу
     * @return количество записей
     */
    long count(FlightsFilter filter);

}
