package main;

import dao.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;


public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("entity");

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //операция инсерт:

        entityManager.persist(new Currency("American dollar","USD","from America", LocalDateTime.now(),LocalDateTime.now()));

        //begin, rollback, commit - комманда не хибернет, а sql
        // всегда должна быть пара begin+commit
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
