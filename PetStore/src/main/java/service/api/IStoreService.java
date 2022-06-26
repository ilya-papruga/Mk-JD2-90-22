package service.api;

import core.EStatus;
import core.dto.OrderDtoCreate;
import core.entity.Order;

import java.util.Map;

public interface IStoreService {

    Map<EStatus, Integer> getInventory();

    Order placeOrder(OrderDtoCreate dto);

    Order getOrder (Long id);

    void deleteOrder (Long id);

}
