package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import service.api.IManagerFactory;

@Service
public class ManagerFactory implements IManagerFactory {

    private final EntityManagerFactory sessionFactory;

    public ManagerFactory() {
        this.sessionFactory = Persistence.createEntityManagerFactory("core.entity");
    }

    public EntityManager createEntityManager() {
        return sessionFactory.createEntityManager();
    }

}
