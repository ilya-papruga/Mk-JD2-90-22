package by.it_academy.jd2.HomeWork.messenger.core.dto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {

    private String login;
    private String password;
    private String fullName;
    private String birthDate;
    private LocalDateTime regDate;
    private RoleType role;

    public User(String login, String password, String fullName, String birthDate) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public User(String login, String password, String fullName, String birthDate, LocalDateTime regDate, RoleType role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.regDate = regDate;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDate;
    }

    public void setBirthDay(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegDate() {
        return regDate.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm:ss"));
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", RegDate=" + getRegDate() +
                ", role=" + role +
                '}';
    }
}
