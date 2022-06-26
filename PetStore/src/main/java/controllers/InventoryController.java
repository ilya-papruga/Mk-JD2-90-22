package controllers;

import core.EStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.IStoreService;

import java.util.Map;

@RestController
@RequestMapping("/store/inventory")
public class InventoryController {
    IStoreService storeService;

    public InventoryController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    Map<EStatus, Integer> getInventory() {
        return storeService.getInventory();
    }

}
