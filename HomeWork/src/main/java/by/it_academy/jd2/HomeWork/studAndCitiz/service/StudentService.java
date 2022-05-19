package by.it_academy.jd2.HomeWork.studAndCitiz.service;

import by.it_academy.jd2.HomeWork.studAndCitiz.dto.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {

    private static final StudentService instance = new StudentService();

    private List<Student> studentList = new ArrayList<>();

    Student student = new Student();
    Student ignat = new Student();
    Student lera = new Student();

    public StudentService() {
        student.setId(1);
        student.setName("Admin");
        student.setAge(20);
        student.setScore(10);
        student.setOlympicGamer(true);
        studentList.add(student);

        ignat.setId(2);
        ignat.setName("Ignat");
        ignat.setAge(22);
        ignat.setScore(9);
        ignat.setOlympicGamer(false);
        studentList.add(ignat);

        lera.setId(3);
        lera.setName("Lera");
        lera.setAge(21);
        lera.setScore(5);
        lera.setOlympicGamer(true);
        studentList.add(lera);
    }



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

