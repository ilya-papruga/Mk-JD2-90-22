package dao;

import dao.api.ICurrencyDao;
import dao.entity.Currency;
import dto.CurrencyCreate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;


@Repository
public class CurrencyDao implements ICurrencyDao {

    @Override
    public Currency add(Currency currency) {

        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();

        return currency;
    }

    @Override
    public void update(Currency currency, Long id, LocalDateTime dtUpdate) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Currency currencyFromDB = entityManager.find(Currency.class, id);

        if(!currencyFromDB.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Валюта уже была обновлена кем-то ранее");
        }

        currencyFromDB.setCode(currency.getCode());
        currencyFromDB.setDescription(currency.getDescription());
        currencyFromDB.setName(currency.getName());

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Currency> getAll() {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

       List<Currency> listOfCurrency =
               entityManager.createQuery("SELECT c FROM c", Currency.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return listOfCurrency;
    }

    @Override
    public Currency get(Long id) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Currency currencyFromDB = entityManager.find(Currency.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return currencyFromDB;
    }

    @Override
    public void delete(Long id, LocalDateTime dtUpdate) {
        EntityManagerFactory sessionFactory =
                Persistence.createEntityManagerFactory("dao");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Currency currencyFromDB = entityManager.find(Currency.class, id);

        if(!currencyFromDB.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Валюта уже была обновлена кем-то ранее");
        }

        entityManager.remove(currencyFromDB);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
