package service;

import core.EStatus;
import core.dao.api.IOrderDao;
import core.dto.OrderDtoCreate;
import core.entity.Order;
import org.springframework.stereotype.Service;
import service.api.IMapperService;
import service.api.IStoreService;

import java.util.Map;

@Service
public class StoreService implements IStoreService {

    IOrderDao orderDao;
    IMapperService mapperService;

    public StoreService(IOrderDao orderDao, IMapperService mapperService) {
        this.orderDao = orderDao;
        this.mapperService = mapperService;
    }

    @Override
    public Map<EStatus, Integer> getInventory() {
        return orderDao.getInventory();
    }

    @Override
    public Order placeOrder(OrderDtoCreate dto) {
       return orderDao.placeOrder(mapperService.mapCreate(dto));
    }

    @Override
    public Order getOrder(Long id) {
       return orderDao.getOrder(id);
    }

    @Override
    public void deleteOrder(Long id) {

        orderDao.deleteOrder(id);
    }
}
