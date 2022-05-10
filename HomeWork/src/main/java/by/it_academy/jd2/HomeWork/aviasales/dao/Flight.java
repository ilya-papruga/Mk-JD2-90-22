package by.it_academy.jd2.HomeWork.aviasales.dao;

public class Flight {

    private String flight_id;
    private String flight_no;
    private String scheduled_departure;
    private String scheduled_departure_local;
    private String scheduled_arrival;
    private String scheduled_arrival_local;
    private String scheduled_duration;
    private String departure_airport;
    private String departure_airport_name;
    private String departure_city;
    private String arrival_airport;
    private String arrival_airport_name;
    private String arrival_city;
    private String status;
    private String aircraft_code;

    public Flight(String scheduled_departure_local, String departure_airport_name,
                  String arrival_airport_name, String scheduled_arrival_local) {

        this.scheduled_departure_local = scheduled_departure_local;
        this.departure_airport_name = departure_airport_name;
        this.arrival_airport_name = arrival_airport_name;
        this.scheduled_arrival_local = scheduled_arrival_local;

    }

    public Flight() {
    }

    public Flight(String flight_id, String flight_no, String scheduled_departure, String scheduled_departure_local,
                  String scheduled_arrival, String scheduled_arrival_local, String scheduled_duration,
                  String departure_airport, String departure_airport_name, String departure_city,
                  String arrival_airport, String arrival_airport_name, String arrival_city, String status, String aircraft_code) {

        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_departure_local = scheduled_departure_local;
        this.scheduled_arrival = scheduled_arrival;
        this.scheduled_arrival_local = scheduled_arrival_local;
        this.scheduled_duration = scheduled_duration;
        this.departure_airport = departure_airport;
        this.departure_airport_name = departure_airport_name;
        this.departure_city = departure_city;
        this.arrival_airport = arrival_airport;
        this.arrival_airport_name = arrival_airport_name;
        this.arrival_city = arrival_city;
        this.status = status;
        this.aircraft_code = aircraft_code;
    }

    public String getScheduled_departure_local() {
        return scheduled_departure_local;
    }

    public void setScheduled_departure_local(String scheduled_departure_local) {
        this.scheduled_departure_local = scheduled_departure_local;
    }

    public String getScheduled_arrival_local() {
        return scheduled_arrival_local;
    }

    public void setScheduled_arrival_local(String scheduled_arrival_local) {
        this.scheduled_arrival_local = scheduled_arrival_local;
    }

    public String getDeparture_airport_name() {
        return departure_airport_name;
    }

    public void setDeparture_airport_name(String departure_airport_name) {
        this.departure_airport_name = departure_airport_name;
    }

    public String getArrival_airport_name() {
        return arrival_airport_name;
    }

    public void setArrival_airport_name(String arrival_airport_name) {
        this.arrival_airport_name = arrival_airport_name;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public String getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(String scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public String getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(String scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public String getScheduled_duration() {
        return scheduled_duration;
    }

    public void setScheduled_duration(String scheduled_duration) {
        this.scheduled_duration = scheduled_duration;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id='" + flight_id + '\'' +
                ", flight_no='" + flight_no + '\'' +
                ", scheduled_departure='" + scheduled_departure + '\'' +
                ", scheduled_departure_local='" + scheduled_departure_local + '\'' +
                ", scheduled_arrival='" + scheduled_arrival + '\'' +
                ", scheduled_arrival_local='" + scheduled_arrival_local + '\'' +
                ", scheduled_duration='" + scheduled_duration + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", departure_airport_name='" + departure_airport_name + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", arrival_airport_name='" + arrival_airport_name + '\'' +
                ", arrival_city='" + arrival_city + '\'' +
                ", status='" + status + '\'' +
                ", aircraft_code='" + aircraft_code + '\'' +
                '}';
    }

}
