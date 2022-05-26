package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.CrossDto;
import by.it_academy.jd2.University.dto.CrossDtoGet;

import java.util.List;

public interface ICrossDao extends AutoCloseable {

    /**
     * Получить все связи групп и студентов
     */
    List<CrossDtoGet> readAll();



    /**
     * Создать новую связь
     * @param cross данные группы и списка студентов
     */
    void create(CrossDto cross);


    /**
     * Удалить существующую связь
     * @param cross данные группы и списка студентов
     */
    void delete(CrossDto cross);

}
