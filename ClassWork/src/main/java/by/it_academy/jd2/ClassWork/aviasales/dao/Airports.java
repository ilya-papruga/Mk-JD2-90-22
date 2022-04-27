package by.it_academy.jd2.ClassWork.aviasales.dao;

public class Airports {

    private String airport_code;
    private String aiport_name;
    private String city;
    private String coordinates;
    private String timezone;

    public Airports() {
    }

    public Airports(String airport_code, String aiport_name, String city, String coordinates, String timezone) {
        this.airport_code = airport_code;
        this.aiport_name = aiport_name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }
}
