package main.no_spring;

import core.entity.Currency;
import jakarta.persistence.EntityManager;
import service.ManagerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MainUpdate {
 /*
    public static void main(String[] args) throws InterruptedException {



        ManagerFactory managerFactory = ManagerFactory.getInstance();
        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = entityManager.find(Currency.class, 1);

        currency.setDtUpdate(LocalDateTime.now());
        currency.setName("Новые данные");

        entityManager.getTransaction().begin();
        entityManager.persist(currency);

         TimeUnit.SECONDS.sleep(60);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

         */

}
