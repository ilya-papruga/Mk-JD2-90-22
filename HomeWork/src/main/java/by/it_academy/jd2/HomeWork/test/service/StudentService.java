package by.it_academy.jd2.HomeWork.test.service;

import by.it_academy.jd2.HomeWork.test.dto.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {

    private static final StudentService instance = new StudentService();

    Student student = new Student();

    public StudentService() {
        student.setId(1);
        student.setName("Admin");
        student.setAge(20);
        student.setScore(10);
        student.setOlympicGamer(true);
        studentList.add(student);
    }

    private List<Student> studentList = new ArrayList<>();

    public void add (Student student)
    {
        studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "student=" + student +
                ", studentList=" + studentList +
                '}';
    }

    public static StudentService getInstance() {
        return instance;
    }



}

