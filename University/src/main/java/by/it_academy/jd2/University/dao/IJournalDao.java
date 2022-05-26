package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.GroupDto;
import by.it_academy.jd2.University.dto.JournalDto;

import java.util.List;

public interface IJournalDao extends AutoCloseable {

    /**
     * Получить все журналы с групп и студентов
     */
    List<JournalDto> readAll();


    /**
     * Получить журнал студентов группы
     *
     * @param groupNumber номер группы
     */
    GroupDto readJournal(String groupNumber);

}
