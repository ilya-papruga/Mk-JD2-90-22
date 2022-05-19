package by.it_academy.jd2.HomeWork.studAndCitiz.service;


import by.it_academy.jd2.HomeWork.studAndCitiz.dto.Citizen;
import by.it_academy.jd2.HomeWork.studAndCitiz.dto.Passport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitizenService {

    private static final CitizenService instance = new CitizenService();


    private List<Citizen> citizenList = new ArrayList<>();

    Citizen citizen = new Citizen();
    Passport p = new Passport("1","0", "odostreet", LocalDate.now());

    public CitizenService() {

        citizen.setId("0");
        citizen.setPassport(p);
        citizen.setName("ignat");
        citizen.setBirthday(LocalDate.ofEpochDay(0));
        citizenList.add(citizen);
    }

    public void add (Citizen citizen)
    {
        citizenList.add(citizen);
    }


    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public static CitizenService getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "CitizenService{" +
                "citizenList=" + citizenList +
                ", citizen=" + citizen +
                '}';
    }
}
