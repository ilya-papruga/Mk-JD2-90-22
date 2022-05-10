package by.it_academy.jd2.HomeWork.aviasales.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {


    public List<Airport> getAll() {
        List<Airport> airports = new ArrayList<>();

        try (Connection connection = getConnection();

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                             "\tFROM bookings.airports ORDER BY city\n"

             );
        ) {
            while (resultSet.next()) {
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return airports;
    }

    public Airport get(String code) {


        try (Connection connection = getConnection();

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                             "\tFROM bookings.airports\n" +
                             "WHERE airport_code = '" + code + " ';"

             );
        ) {
            while (resultSet.next()) {
                return map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres");


    }


    private Airport map(ResultSet rs) throws SQLException {
        return new Airport(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }


}
