package core.dao;

import core.EStatus;
import core.dao.api.IOrderDao;
import core.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import service.StatusCodeCount;
import service.api.IManagerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao implements IOrderDao {

    private final IManagerFactory managerFactory;

    public OrderDao(IManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public Map<EStatus, Integer> getInventory() {

        EntityManager entityManager = managerFactory.createEntityManager();

        Map<EStatus, Integer> inventory = new HashMap<>();

        List<StatusCodeCount> result = entityManager.createNamedQuery(
                "StatusCodes", StatusCodeCount.class).getResultList();

        for (StatusCodeCount statusCodeCount : result) {
            inventory.put(statusCodeCount.getStatus(), statusCodeCount.getCount());
        }

        return inventory;

    }

    @Override
    public Order placeOrder(Order order) {
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        entityManager.close();

        return order;
    }



    @Override
    public Order getOrder(Long id) {

        EntityManager entityManager = managerFactory.createEntityManager();

        Order result = entityManager.createQuery("from Order where id =" + id, Order.class).getSingleResult();

        entityManager.close();

        return result;
    }

    @Override
    public void deleteOrder(Long id) {

        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Order order = entityManager.find(Order.class, id);

        entityManager.remove(order);

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
