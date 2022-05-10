package by.it_academy.jd2.ClassWork.aviasales.main;

import java.sql.*;
import java.util.Scanner;

public class Main5 {


    private static final String QUERY = "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
            "\tFROM bookings.airports\n" +
            "WHERE airport_code = ?;";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверьте имя драйвера", e);
        }


        Scanner console = new Scanner(System.in);

        System.out.println("Введите код аэропорта");
        String code = console.nextLine();

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "postgres");

             PreparedStatement statement = connection.prepareStatement(QUERY);

        ) {

            statement.setString(1, code);
            try(ResultSet resultSet = statement.executeQuery();){

                while (resultSet.next()) {

                    System.out.println(resultSet.getString("airport_name"));
                }

        }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
}
