package by.it_academy.jd2.ClassWork.aviasales.dao;

import java.util.List;

public interface IFlightsDao extends AutoCloseable {

    /**
     * Получить все полёты
     * @return
     */
    List<Flights> getAll();



    /**
     * Получить все полёты
     * @return
     */
    List<Flights> list(FlightsFilter filter, Pageable pageable);


    /**
     * Получить полёт
     * @param id PK полёта
     * @return
     */

    Flights get (Long id);

}
