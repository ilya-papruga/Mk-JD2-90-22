package controller;

import dto.CurrencyCreate;
import dao.entity.Currency;
import org.springframework.web.bind.annotation.*;
import service.api.ICurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final ICurrencyService currencyService;

    public CurrencyController(ICurrencyService currencyService) {

        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> list() {
        return this.currencyService.getAll();
    }

    @GetMapping("/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public Currency get(@PathVariable Long id) {
        return this.currencyService.get(id);
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public Currency create(@RequestBody CurrencyCreate dto) {

        return this.currencyService.add(dto);
    }
}
