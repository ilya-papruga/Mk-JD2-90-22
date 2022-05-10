package by.it_academy.jd2.ClassWork.aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao implements IAirportDao {

    private DataSource ds;

    public AirportPoolDao(){

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



    public List<Airport> getAll() {
        List<Airport> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT airport_code, airport_name, city, coordinates, timezone\n" +
                             "\tFROM bookings.airports\n"

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

        return this.ds.getConnection();
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


    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
