package main;

import core.entity.Currency;
import jakarta.persistence.EntityManager;
import service.ManagerFactory;

import java.util.concurrent.TimeUnit;

public class MainUpdate {

    public static void main(String[] args) throws InterruptedException {

        ManagerFactory managerFactory = ManagerFactory.getInstance();
        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = entityManager.find(Currency.class, 1);

        currency.setName("Старые данные");

        entityManager.getTransaction().begin();
        entityManager.persist(currency);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
