package by.it_academy.jd2.HomeWork.studAndCitiz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 	1. ИД гражданина
 * 	2. Кем выдан
 * 	3. Дата выдачи (LocalDate)
 * 	4. ИД паспорта
 */
public class Passport {
    private String id;
    private String idCitizen;
    private String address;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private LocalDate createDate;

    public Passport(@JsonProperty("id")String id,@JsonProperty("id_citizen") String idCitizen, @JsonProperty("address") String address, @JsonProperty("create_date") LocalDate createDate) {
        this.id = id;
        this.idCitizen = idCitizen;
        this.address = address;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id='" + id + '\'' +
                ", idCitizen='" + idCitizen + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

