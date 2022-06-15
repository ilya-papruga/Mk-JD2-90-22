package controllers;

import core.dto.CurrencyDtoCU;
import core.entity.Currency;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/currency")
public class CurrencyController {

    @GetMapping
    public List<Currency> list (){

        Currency currency = new Currency();
        List<Currency> currencies = new ArrayList<>();

        currency.setName("Dollar");
        currency.setDescription("Доллар США");
        currency.setCode("USD");


        currencies.add(currency);


        return currencies;

    }

    @GetMapping ("/{id}")

    // @RequestMapping (value = "/{id}", method = RequestMaethod.GET) //аналог @GetMapping
    public Currency get(@PathVariable Long id){
        return null;
    }


    @PostMapping

    // @RequestMapping (method = RequestMethod.POST) // аналог @PostMapping
    public Currency create (@RequestBody CurrencyDtoCU dto){

        return null;

    }
}
