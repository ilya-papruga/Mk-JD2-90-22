package by.it_academy.jd2.HomeWork.aviasales.dao;

import java.util.List;

public interface IAirportDao extends AutoCloseable {

    /**
     * Получить все аэропорты
     * @return
     */
    List<Airport> getAll();


    /**
     * Получить аэропорт
     * @param code код эропорта
     * @return
     */

    Airport get (String code);


}
