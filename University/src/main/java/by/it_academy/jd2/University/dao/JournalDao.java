package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.JournalDto;
import by.it_academy.jd2.University.service.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JournalDao implements IJournalDao {

    private final static JournalDao instance = new JournalDao();

    private final static String SELECT_JOIN_SQL_ALL =
            "SELECT\n" +
            "    groups.\"number\",\n" +
            "    name,\n" +
            "    age,\n" +
            "    score,\n" +
            "    olympic_gamer\n" +
            "FROM\n" +
            "    main.students\n" +
            "    JOIN main.cross_groups_students ON students.id = student_id\n" +
            "    JOIN main.groups ON groups.id = group_id\n"+
            "ORDER BY groups.\"number\", name;";

    private final static String SELECT_JOIN_SQL_ONE =
            "SELECT\n" +
            "    groups.\"number\",\n" +
            "    name,\n" +
            "    age,\n" +
            "    score,\n" +
            "    olympic_gamer\n" +
            "FROM\n" +
            "    main.students\n" +
            "    JOIN main.cross_groups_students ON students.id = student_id\n" +
            "    JOIN main.groups ON groups.id = group_id\n"+
            "WHERE groups.\"number\" = ?\n" +
             "ORDER BY name;";


     public List<JournalDto> readAll() {

        List<JournalDto> journalList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_JOIN_SQL_ALL);
        ) {
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    journalList.add(mapJournal(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journalList;
    }

    public List<JournalDto> readJournal(String groupNumber) {

        List<JournalDto> journalList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_JOIN_SQL_ONE);
        ) {
            statement.setString(1, groupNumber);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    journalList.add(mapJournal(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return journalList;
    }


    private JournalDto mapJournal(ResultSet rs) throws SQLException {
        JournalDto journal = new JournalDto();
        journal.setNumber(rs.getString("number"));
        journal.setName(rs.getString("name"));
        journal.setAge(rs.getInt("age"));
        journal.setScore(rs.getDouble("score"));
        journal.setOlympicGamer(rs.getBoolean("olympic_gamer"));
        return journal;
    }


    @Override
    public void close() throws Exception {
        ConnectionFactory.close();
    }

    public static JournalDao getInstance() {
        return instance;
    }
}

