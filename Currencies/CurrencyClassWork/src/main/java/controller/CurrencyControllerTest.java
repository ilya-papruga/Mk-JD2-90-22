package controller;

import dao.entity.Currency;
import dto.CurrencyCreate;
import org.springframework.web.bind.annotation.*;
import service.api.ICurrencyService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/currency_test")
public class CurrencyControllerTest {

    private final ICurrencyService currencyService;

    public CurrencyControllerTest(ICurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<Currency> list() {

        List<Currency> currencies = new ArrayList<>();

        currencies.add(new Currency());

        currencies.add(new Currency("USD","Американский доллар", "123", LocalDateTime.now(), LocalDateTime.now()));

        return currencies;

    }

    @GetMapping("/{id}")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //аналог @GetMapping
    public Currency get(@PathVariable Long id) {

        return new Currency("USD","Американский доллар", "123", LocalDateTime.now(), LocalDateTime.now());
    }

    @PutMapping("/{id}/version/{version}")
    public Currency put(@PathVariable Long id, @PathVariable Long version){
        return null;
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST) //аналог @PostMapping
    public Currency create(@RequestBody CurrencyCreate dto) {

        return new Currency(dto.getName(), dto.getDescription(), dto.getCode(),LocalDateTime.now(), LocalDateTime.now() );
    }
}
