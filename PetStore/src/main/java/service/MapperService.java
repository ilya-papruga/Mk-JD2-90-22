package service;

import core.EStatus;
import core.dto.OrderDtoCreate;
import core.dto.OrderDtoRead;
import core.entity.Order;
import org.springframework.stereotype.Service;
import service.api.IMapperService;

import java.time.OffsetDateTime;

@Service
public class MapperService implements IMapperService {

    @Override
    public OrderDtoRead mapRead(Order order) {

        OrderDtoRead dto = new OrderDtoRead();

        dto.setId(order.getId());
        dto.setDtCreate(order.getDtCreate());
        dto.setDtUpdate(order.getDtUpdate());
        dto.setPetId(order.getPetId());
        dto.setQuantity(order.getQuantity());
        dto.setShipDate(order.getShipDate());
        dto.setEStatus(order.getStatus());
        dto.setComplete(order.isComplete());

        return dto;
    }

    @Override
    public Order mapCreate(OrderDtoCreate dto) {

        Order order = new Order();

        order.setDtCreate(OffsetDateTime.now());
        order.setDtUpdate(order.getDtCreate());
        order.setPetId(dto.getPetId());
        order.setQuantity(dto.getQuantity());
        order.setShipDate(dto.getShipDate());

        order.setStatus(EStatus.PLACED);
        order.setComplete(false);

        return order;

    }
}
