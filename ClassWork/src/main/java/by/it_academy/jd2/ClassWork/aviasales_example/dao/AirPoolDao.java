package by.it_academy.jd2.ClassWork.aviasales_example.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class AirPoolDao {

    private DataSource ds;

    public AirPoolDao() {

        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException();
        }
    }
}
