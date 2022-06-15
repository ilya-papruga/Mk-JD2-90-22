package service.api;

import jakarta.persistence.EntityManager;

public interface IManagerFactory {

    EntityManager createEntityManager();

}
