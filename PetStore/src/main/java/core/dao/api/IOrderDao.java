package core.dao.api;

import core.EStatus;
import core.entity.Order;

import java.util.Map;

public interface IOrderDao {

    Map<EStatus, Integer> getInventory();
    Order placeOrder(Order order);

    Order getOrder(Long id);

    void deleteOrder(Long id);
}
