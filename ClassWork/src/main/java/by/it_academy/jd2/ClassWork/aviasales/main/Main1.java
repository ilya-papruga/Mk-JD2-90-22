package by.it_academy.jd2.ClassWork.aviasales.main;

import by.it_academy.jd2.ClassWork.aviasales.dao.Airports;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {


    public static void main(String[] args) {

        List<Airports> airportsList = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверьте имя драйвера", e);
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                             "\tFROM bookings.airports\n" +
                             "\tWHERE city NOT in ('Сочи', 'Краснодар')\n" +
                             "\tLIMIT 100;"
             );
        ) {
            while (resultSet.next()) {
                airportsList.add(new Airports(
                        resultSet.getString("airport_code"),
                        resultSet.getString("airport_name"),
                        resultSet.getString("city"),
                        resultSet.getString("coordinates"),
                        resultSet.getString("timezone")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        for (Airports airports : airportsList) {
            System.out.println(airports);
        }

    }
}
