package controllers;

import core.dto.OrderDtoCreate;
import core.dto.OrderDtoRead;
import org.springframework.web.bind.annotation.*;
import service.api.IMapperService;
import service.api.IStoreService;

@RestController
@RequestMapping("/store/order")
public class OrderController {

    IStoreService storeService;
    IMapperService mapperService;

    public OrderController(IStoreService storeService, IMapperService mapperService) {
        this.storeService = storeService;
        this.mapperService = mapperService;
    }

    @PostMapping
    public OrderDtoRead placeOrder(@RequestBody OrderDtoCreate dto) {

        return mapperService.mapRead(storeService.placeOrder(dto));
    }

    @GetMapping("/{id}")
    public OrderDtoRead getOrder(@PathVariable Long id) {

        return mapperService.mapRead(storeService.getOrder(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder (@PathVariable Long id){

        storeService.deleteOrder(id);
    }

}
