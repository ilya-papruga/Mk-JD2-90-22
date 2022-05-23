package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.StudentDto;
import by.it_academy.jd2.University.dto.StudentId;
import by.it_academy.jd2.University.dto.StudentNoId;
import by.it_academy.jd2.University.entity.Student;

import java.util.List;

public interface IStudentDao extends AutoCloseable{

    /**
     * Получить всех студентов
     * @return
     */
    List<Student> readAll();

    /**
     * Создать нового студента
     * @param student студент без id
     */
    String create(StudentNoId student);

    /**
     * Удалить студента
     * @param id id студента
     */
    void delete(StudentId id);


    /**
     * Обновление записи по студенту
     * @param dto обновлённая информация
     * @param id указанаие id студента
     */
    void update(StudentDto dto, Long id);

}
