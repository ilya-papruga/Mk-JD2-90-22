package by.it_academy.jd2.ClassWork.aviasales.main;

import by.it_academy.jd2.ClassWork.aviasales.dao.Airport;
import by.it_academy.jd2.ClassWork.aviasales.dao.AirportDao;
import by.it_academy.jd2.ClassWork.aviasales.dao.AirportPoolDao;
import by.it_academy.jd2.ClassWork.aviasales.dao.IAirportDao;

import java.util.List;

public class Main3 {


    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверьте имя драйвера", e);
        }


        try (IAirportDao airportDao1 = new AirportDao();) {
            job(airportDao1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("____________");

        try (IAirportDao airportDao2 = new AirportPoolDao();) {
            job(airportDao2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void job(IAirportDao dao) {
        long start = System.currentTimeMillis();
        List<Airport> airports = dao.getAll();
        long stop = System.currentTimeMillis();


        //Время получения всех списком
        System.out.println(stop - start);

        start = System.currentTimeMillis();
        for (Airport airport : airports) {
            dao.get(airport.getCode());
        }
        stop = System.currentTimeMillis();


        //Время получения всех по одной
        System.out.println(stop - start);


    }
}
