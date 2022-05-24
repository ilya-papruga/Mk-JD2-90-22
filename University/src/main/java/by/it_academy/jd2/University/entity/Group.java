package by.it_academy.jd2.University.entity;


public class Group {

    private long id;
    private String number;


    public Group() {
    }

    public Group(long id, String number) {
        this.id = id;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
