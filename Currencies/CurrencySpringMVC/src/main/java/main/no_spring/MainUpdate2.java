package main.no_spring;

import core.entity.Currency;
import jakarta.persistence.EntityManager;
import service.ManagerFactory;

import java.time.LocalDateTime;

public class MainUpdate2 {

    /*

    public static void main(String[] args) throws InterruptedException {



        ManagerFactory managerFactory = ManagerFactory.getInstance();
        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = entityManager.find(Currency.class, 1);

        currency.setDtUpdate(LocalDateTime.now());
        currency.setName("Ещё новые данные");

        entityManager.getTransaction().begin();
        entityManager.persist(currency);

        // TimeUnit.SECONDS.sleep(30);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
     */

}
