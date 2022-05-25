package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.CrossDto;
import by.it_academy.jd2.University.dto.CrossDtoGet;
import by.it_academy.jd2.University.dto.JournalDto;

import java.util.List;

public interface ICrossDao extends AutoCloseable {

    /**
     * Получить все связи групп и студентов
     */
    public List<CrossDtoGet> readAll();



    /**
     * Создать новую связь
     * @param cross данные группы и списка студентов
     */
    public void create(CrossDto cross);


    /**
     * Удалить существующую связь
     * @param cross данные группы и списка студентов
     */
    public void delete(CrossDto cross);

}
