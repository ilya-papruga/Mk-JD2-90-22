package by.it_academy.jd2.ClassWork.aviasales_example.dao;

public class Air {

    private String airport_code;
    private String aiport_name;
    private String city;
    private String coordinates;
    private String timezone;

    @Override
    public String toString() {
        return "Airport{" +
                "airport_code='" + airport_code + '\'' +
                ", aiport_name='" + aiport_name + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }

    public Air() {
    }

    public Air(String airport_code, String aiport_name, String city, String coordinates, String timezone) {
        this.airport_code = airport_code;
        this.aiport_name = aiport_name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getAirport_code() {
        return airport_code;
    }

    public String getAiport_name() {
        return aiport_name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getTimezone() {
        return timezone;
    }
}
