package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.GroupNoId;
import by.it_academy.jd2.University.entity.Group;

import java.util.List;

public interface IGroupDao extends AutoCloseable{

    /**
     * Получить все группы
     */
    List<Group> readAll();

    /**
     * Создать новую группу
     * @param group группа без id
     */
    String create(GroupNoId group);

    /**
     * Удалить группу
     * @param id id группы
     */
    void delete(Long id);


    /**
     * Обновление записи по группе
     * @param group обновлённый номер группы
     * @param id указанаие id группы
     */
    void update(GroupNoId group, Long id);

}
