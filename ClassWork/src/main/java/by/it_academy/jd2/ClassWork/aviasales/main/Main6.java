package by.it_academy.jd2.ClassWork.aviasales.main;

import by.it_academy.jd2.ClassWork.aviasales.dao.Flights;

public class Main6 {

    public static void main(String[] args) {

        Flights flights = Flights.Builder.create()
                .setArrivalAirportName("MCK")
                .build();

        Flights.Builder builder = Flights.Builder.create();

        builder.setArrivalCity("Москва");


        Flights flights1 = builder.build();

        // builder.setArrivalCity("Минск");

        builder.setArrivalAirportName("TEST");

        Flights flights2 = builder.build();

        System.out.println(flights);
        System.out.println(flights1);
        System.out.println(flights2);

       /* Flights flights3 = new Flights();
        flights3.setArrivalAirport("VST");
        flights3.setArrivalAirport("VST666");
        System.out.println(flights3);
        */
    }
}
