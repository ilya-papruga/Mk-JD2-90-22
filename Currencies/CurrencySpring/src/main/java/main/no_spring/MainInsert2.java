package main.no_spring;

import core.entity.Currency;
import jakarta.persistence.EntityManager;
import service.ManagerFactory;

import java.time.LocalDateTime;

public class MainInsert2 {

    /*
    public static void main(String[] args) {

        ManagerFactory managerFactory = ManagerFactory.getInstance();

        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = new Currency();

        currency.setDtCreate(LocalDateTime.now());
        currency.setDtUpdate(LocalDateTime.now());
        currency.setName("Валюта3");
        currency.setDescription("Тестовая валюта3");
        currency.setCode("DDS");

        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

     */

}
