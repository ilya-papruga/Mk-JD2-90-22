package dao;

import core.entity.Currency;
import dao.api.ICurrencyDao;
import jakarta.persistence.EntityManager;
import service.ManagerFactory;


import java.util.List;

public class CurrencyDao implements ICurrencyDao {

    private final static CurrencyDao instance = new CurrencyDao();

    private final ManagerFactory managerFactory;

    public CurrencyDao() {
        this.managerFactory = ManagerFactory.getInstance();
    }

    public void create(Currency currency){
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Currency read (long id){

        EntityManager entityManager = managerFactory.createEntityManager();

        Currency result = entityManager.createQuery("from Currency where id =" + id, Currency.class).getSingleResult();

        entityManager.close();

        return result;
    }

    public List<Currency> readAll(){

        EntityManager entityManager = managerFactory.createEntityManager();
        List<Currency> result = entityManager.createQuery("from Currency", Currency.class).getResultList();
        entityManager.close();

        return result;
    }


    public void update(long id, Currency currencyUpdater){

        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = entityManager.find(Currency.class, id);

        currency.setDtUpdate(currencyUpdater.getDtUpdate());
        currency.setName(currencyUpdater.getName());
        currency.setDescription(currencyUpdater.getDescription());
        currency.setCode(currencyUpdater.getCode());

        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(long id){

        EntityManager entityManager = managerFactory.createEntityManager();

        Currency currency = entityManager.find(Currency.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(currency);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static CurrencyDao getInstance() {
        return instance;
    }

}
