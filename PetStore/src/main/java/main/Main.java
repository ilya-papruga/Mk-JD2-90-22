package main;

import core.EStatus;
import core.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.OffsetDateTime;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("core.entity");

        EntityManager entityManager = sessionFactory.createEntityManager();


        Order order = new Order();

        order.setDtCreate(OffsetDateTime.now());
        order.setDtUpdate(order.getDtCreate());
        order.setPetId(1l);
        order.setQuantity(10);
        order.setShipDate(OffsetDateTime.now());
        order.setStatus(EStatus.PLACED);
        order.setComplete(false);

        entityManager.getTransaction().begin();

        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
