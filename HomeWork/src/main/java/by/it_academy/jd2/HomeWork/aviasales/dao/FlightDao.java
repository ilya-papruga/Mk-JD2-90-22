package by.it_academy.jd2.HomeWork.aviasales.dao;

import by.it_academy.jd2.HomeWork.aviasales.service.FlightsService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements AutoCloseable {

    private DataSource ds;
    private FlightsService service;


    public FlightDao() {
        this.service = FlightsService.getInstance();

        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!!", e);
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");

        this.ds = pool;
    }


    public List<Flight> getAll() {


        List<Flight> flights = new ArrayList<>();

        try (Connection connection = getConnection();

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT flight_id, flight_no, scheduled_departure, scheduled_departure_local, scheduled_arrival, scheduled_arrival_local, scheduled_duration, departure_airport, departure_airport_name, departure_city, arrival_airport, arrival_airport_name, arrival_city, status, aircraft_code\n" +
                             "\tFROM bookings.flights_v"

             );
        ) {
            while (resultSet.next()) {
                flights.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return flights;
    }


    public List<Flight> get(Flight flight) {

        List<Flight> flights = new ArrayList<>();

        String depDate = flight.getScheduled_departure_local();
        String depAirport = flight.getDeparture_airport_name();
        String arrDate = flight.getScheduled_arrival_local();
        String arrAirport = flight.getArrival_airport_name();


        try (Connection connection = getConnection();

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_departure_local,\n" +
                             "    scheduled_arrival,\n" +
                             "    scheduled_arrival_local,\n" +
                             "    scheduled_duration,\n" +
                             "    departure_airport,\n" +
                             "    departure_airport_name,\n" +
                             "    departure_city,\n" +
                             "    arrival_airport,\n" +
                             "    arrival_airport_name,\n" +
                             "    arrival_city,\n" +
                             "    status,\n" +
                             "    aircraft_code\n" +
                             "FROM\n" +
                             "    bookings.flights_v\n" +
                             "WHERE\n" +
                             "    departure_airport_name = '" + depAirport + "';"
             );
        ) {
            while (resultSet.next()) {
                flights.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return flights;
    }

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres");


    }

    private Flight map(ResultSet rs) throws SQLException {
        return new Flight(
                rs.getString("flight_id"),
                rs.getString("flight_no"),
                rs.getString("scheduled_departure"),
                rs.getString("scheduled_departure_local"),
                rs.getString("scheduled_arrival"),
                rs.getString("scheduled_arrival_local"),
                rs.getString("scheduled_duration"),
                rs.getString("departure_airport"),
                rs.getString("departure_airport_name"),
                rs.getString("departure_city"),
                rs.getString("arrival_airport"),
                rs.getString("arrival_airport_name"),
                rs.getString("arrival_city"),
                rs.getString("status"),
                rs.getString("aircraft_code"));

    }


    @Override
    public void close() throws Exception {

        DataSources.destroy(this.ds);

    }


}
