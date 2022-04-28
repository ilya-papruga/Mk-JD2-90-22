package by.it_academy.jd2.ClassWork.aviasales_example.main;

import by.it_academy.jd2.ClassWork.aviasales_example.dao.Air;
import by.it_academy.jd2.ClassWork.aviasales_example.dao.AirDao;

import java.util.List;

public class Main1 {


    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверьте имя драйвера", e);
        }

        AirDao airDao = new AirDao();
        List<Air> airs = airDao.getAll();

        //for (Airport airport : airports) {System.out.println(airport);}


      // System.out.println(airportDao.get("CNN"));


        long start = System.currentTimeMillis();

        long stop = System.currentTimeMillis();
    }
}
