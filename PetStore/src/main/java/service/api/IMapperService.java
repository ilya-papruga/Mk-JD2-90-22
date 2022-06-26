package service.api;

import core.dto.OrderDtoCreate;
import core.dto.OrderDtoRead;
import core.entity.Order;

public interface IMapperService {

    OrderDtoRead mapRead (Order order);

    Order mapCreate (OrderDtoCreate dto);

}
