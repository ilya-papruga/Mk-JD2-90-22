package by.it_academy.jd2.ClassWork.jsp.service;

import java.util.List;
import java.util.Random;

public class NameGeneratorService {

    public static String[] names = {
            "Илья", "Антон", "Иван"
    };

    public static String getRandomName(){
        Random rnd = new Random();

        return names[rnd.nextInt(names.length)];

    }

    public static List<String> getAllNames(){
        return List.of(names);
    }
}
