package by.it_academy.jd2.University.dao;

import by.it_academy.jd2.University.dto.CrossDtoGet;
import by.it_academy.jd2.University.dto.CrossDto;
import by.it_academy.jd2.University.service.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrossDao implements ICrossDao {

    private final static CrossDao instance = new CrossDao();

    private final static String SELECT_SQL =
            "SELECT\n" +
            "    group_id,\n" +
            "    student_id\n" +
            "FROM\n" +
            "    main.cross_groups_students;";

    private final static String INSERT_SQL =
            "INSERT INTO main.cross_groups_students" +
            " (group_id, student_id)\n" +
            "    VALUES (?, ?);";

    private final static String DELETE_SQL =
            "DELETE FROM main.cross_groups_students\n" +
            "WHERE group_id = ?\n" +
            "AND student_id = ?;";



    public List<CrossDtoGet> readAll() {

        List<CrossDtoGet> crossList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL)
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    crossList.add(mapCross(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return crossList;
    }


      public void create(CrossDto cross) {
          for (int i = 0; i < cross.getStudentId().size(); i++) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)
        ) {

                statement.setLong(1, cross.getGroupId());
                statement.setLong(2, cross.getStudentId().get(i));

            {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
          }
    }

    public void delete(CrossDto cross) {
          for (int i = 0; i < cross.getStudentId().size(); i++) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)
        ) {
                statement.setLong(1, cross.getGroupId());
                statement.setLong(2, cross.getStudentId().get(i));

            {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
          }
    }

    private CrossDtoGet mapCross(ResultSet rs) throws SQLException {
        CrossDtoGet cross = new CrossDtoGet();
        cross.setGroupId(rs.getLong("group_id"));
        cross.setStudentId(rs.getLong("student_id"));
        return cross;
    }

    @Override
    public void close() throws Exception {
        ConnectionFactory.close();
    }

    public static CrossDao getInstance() {
        return instance;
    }
}
