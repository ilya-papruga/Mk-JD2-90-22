package core.dao;

import core.entity.Currency;
import core.dao.api.ICurrencyDao;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import service.api.IManagerFactory;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CurrencyDao implements ICurrencyDao {

    private final IManagerFactory managerFactory;

    public CurrencyDao(IManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    public Currency create(Currency currency){
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(currency);
        entityManager.getTransaction().commit();
        entityManager.close();

        return currency;
    }

    public Currency read (Long id){

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


    public void update(Long id, Currency currencyUpdater, LocalDateTime dtUpdate){

        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Currency currency = entityManager.find(Currency.class, id);

        if(!currency.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Валюта уже была обновлена кем-то ранее");
        }

        currency.setName(currencyUpdater.getName());
        currency.setDescription(currencyUpdater.getDescription());
        currency.setCode(currencyUpdater.getCode());

        entityManager.persist(currency);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id, LocalDateTime dtUpdate){

        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Currency currency = entityManager.find(Currency.class, id);

        if(!currency.getDtUpdate().equals(dtUpdate)){
            throw new IllegalArgumentException("Валюта уже была удалена или обновлена кем-то ранее");
        }

        entityManager.remove(currency);

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
