package by.it_academy.jd2.University.entity;

import java.util.List;

public class Group {
    private String number;
    private List<Student> studentList;

    public Group(String number) {
        this.number = number;
    }

    public Group(String number, List<Student> studentList) {
        this.number = number;
        this.studentList = studentList;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
