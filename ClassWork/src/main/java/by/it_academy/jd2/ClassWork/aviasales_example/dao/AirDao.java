package by.it_academy.jd2.ClassWork.aviasales_example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirDao {


    public List<Air> getAll() {


        List<Air> airs = new ArrayList<>();

        try (Connection connection = getConnection();

             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                             "\tFROM bookings.airports\n"

             );
        ) {
            while (resultSet.next()) {
                airs.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return airs;
    }

    public Air get(String code) {


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


    private Air map(ResultSet rs) throws SQLException {
        return new Air(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }

}
