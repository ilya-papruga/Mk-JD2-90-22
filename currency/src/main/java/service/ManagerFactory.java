package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerFactory {

    private static final ManagerFactory instance = new ManagerFactory();
    private final EntityManagerFactory sessionFactory;

    public ManagerFactory() {
        this.sessionFactory = Persistence.createEntityManagerFactory("core.entity");
    }

    public EntityManager createEntityManager() {
        return sessionFactory.createEntityManager();
    }


    public static ManagerFactory getInstance() {
        return instance;
    }

}
