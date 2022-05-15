package by.it_academy.jd2.ClassWork.aviasales.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsDao implements IFlightsDao {

    private final static FlightsDao instance = new FlightsDao();

    private final static String SELECT_SQL = "SELECT\n" +
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
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v\n";

    @Override
    public List<Flights> getAll() {

        return list (null, Pageable.of(0, 0));
    }

    @Override
    public List<Flights> list(FlightsFilter filter, Pageable pageable) {

        if (filter == null){
            filter = FlightsFilter.Builder.create().build();
        }

        if (pageable == null){
            pageable = Pageable.of(25, 1);
        }

        List<Flights> flights = new ArrayList<>();

        List<Object> params = new ArrayList<>();

        String where = "";

        if (filter.getArrivalAirport() != null) {
            where += " arrival_airport = ?";
            params.add(filter.getArrivalAirport());
        }

        if (filter.getDepartureAirport() != null) {
            if(where.length() > 0) {
                where += " AND ";
            }
            where += " departure_airport = ?";

            params.add(filter.getDepartureAirport());
        }

        if (filter.getScheduledArrivalLocal() != null) {
            if(where.length() > 0) {
                where += " AND ";
            }
            where += " scheduled_arrival_local = ?";

            params.add(filter.getScheduledArrivalLocal());
        }

        if (filter.getScheduledDepartureLocal() != null) {
            if(where.length() > 0) {
                where += " AND ";
            }
            where += " scheduled_departure_local = ?";

            params.add(filter.getScheduledDepartureLocal());
        }

        if (where.length() > 0) {
            where = " WHERE " + where;
        }

        String page = "";


        if(pageable.getSize() > 0){
             page += " LIMIT " + pageable.getSize();
        }

        if(pageable.getPage() > 0){

            int offset = pageable.getSize() * (pageable.getPage() - 1);

            page += " OFFSET " + offset;
        }



        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL + where + page);
        ) {
            int index = 0;
            for (Object param : params) {
                statement.setObject(++index, param);

            }
            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()) {
                    flights.add (map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }



        return flights;
    }

    @Override
    public Flights get(Long id) {

        if (id == null){
            throw new IllegalArgumentException("ID не задан");
        }


        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL + "WHERE flight_id = ?;");
        ) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()) {
                    return map(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    private Flights map(ResultSet rs) throws SQLException {

        return Flights.Builder.create()
                .setFlightId(rs.getLong("flight_id"))
                .setFlightNo(rs.getString("flight_no"))
//                .setScheduledDeparture(rs.getString("scheduled_departure"))
//                .setScheduledDepartureLocal(rs.getString("scheduled_departure_local"))
//                .setScheduledArrival(rs.getString("scheduled_arrival"))
//                .setScheduledArrivalLocal(rs.getString("scheduled_arrival_local"))
//                .setScheduledDuration(rs.getString("scheduled_duration"))
                .setDepartureAirport(rs.getString("departure_airport"))
                .setDepartureAirportName(rs.getString("departure_airport_name"))
                .setDepartureCity(rs.getString("departure_city"))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setArrivalAirportName(rs.getString("arrival_airport_name"))
                .setArrivalCity(rs.getString("arrival_city"))
                .setStatus(rs.getString("status"))
                .setAircraftCode(rs.getString("aircraft_code"))
//                .setActualDeparture(rs.getString("actual_departure"))
//                .setActualDepartureLocal(rs.getString("actual_departure_local"))
//                .setActualArrival(rs.getString("actual_arrival"))
//                .setActualArrivalLocal(rs.getString("actual_arrival_local"))
//                .setActualDuration(rs.getString("actual_duration"))
                .build();

    }

    @Override
    public void close() throws Exception {

        ConnectionFactory.close();

    }

    public static FlightsDao getInstance(){
        return instance;
    }
}
