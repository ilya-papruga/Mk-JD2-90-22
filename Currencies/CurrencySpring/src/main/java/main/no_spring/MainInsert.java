package main.no_spring;

import core.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class MainInsert {

    public static void main(String[] args) {

        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("core.entity");
        EntityManager entityManager = sessionFactory.createEntityManager();

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

}
