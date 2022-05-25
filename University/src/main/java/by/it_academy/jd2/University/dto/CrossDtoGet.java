package by.it_academy.jd2.University.dto;

public class CrossDtoGet {

    private long groupId;
    private String number;
    private long studentId;
    private String name;

    public CrossDtoGet() {
    }

    public long getGroupId() {
        return groupId;
    }

    public String getNumber() {
        return number;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
