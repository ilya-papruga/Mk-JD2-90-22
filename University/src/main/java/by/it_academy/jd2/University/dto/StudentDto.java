package by.it_academy.jd2.University.dto;

import java.io.Serializable;
import java.util.Objects;

public class StudentDto {

    private int id;
    private String name;
    private int age;
    private double score;
    private boolean olympicGamer;

    public StudentDto() {
    }

    public StudentDto(int id, String name, int age, double score, boolean olympicGamer) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.olympicGamer = olympicGamer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isOlympicGamer() {
        return olympicGamer;
    }

    public void setOlympicGamer(boolean olympicGamer) {
        this.olympicGamer = olympicGamer;
    }

}

