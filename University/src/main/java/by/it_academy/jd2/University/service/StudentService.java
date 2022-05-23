package by.it_academy.jd2.University.service;

import by.it_academy.jd2.University.dao.StudentDao;
import by.it_academy.jd2.University.dto.StudentDto;
import by.it_academy.jd2.University.dto.StudentId;
import by.it_academy.jd2.University.dto.StudentNoId;
import by.it_academy.jd2.University.entity.Student;

import java.util.List;

public class StudentService {

    private static final StudentService instance = new StudentService();

    private final StudentDao dao;

    public StudentService() {
        this.dao = StudentDao.getInstance();
    }

    public List<Student> readAll() {

        return this.dao.readAll();
    }

    public String create(StudentNoId student) {

        return this.dao.create(student);
    }

    public void delete(StudentId student) {
        this.dao.delete(student);
    }

    public void update(StudentDto student, Long id) {
        this.dao.update(student, id);
    }

    public static StudentService getInstance() {
        return instance;
    }

}
