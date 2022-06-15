package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import service.api.IManagerFactory;

public class ManagerFactory implements IManagerFactory {

    private final EntityManagerFactory sessionFactory;

    public ManagerFactory() {
        this.sessionFactory = Persistence.createEntityManagerFactory("core.entity");
    }

    public EntityManager createEntityManager() {
        return sessionFactory.createEntityManager();
    }

}
