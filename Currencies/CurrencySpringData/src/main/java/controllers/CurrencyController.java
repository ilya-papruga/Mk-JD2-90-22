package controllers;

import core.dto.CurrencyDtoCreate;
import core.dto.CurrencyDtoRead;
import core.dto.CurrencyDtoUpdate;
import core.entity.Currency;
import org.springframework.web.bind.annotation.*;
import service.api.ICurrencyService;
import service.api.IMapperService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final ICurrencyService currencyService;
    private final IMapperService mapperService;

    public CurrencyController(ICurrencyService currencyService, IMapperService mapperService) {
        this.currencyService = currencyService;
        this.mapperService = mapperService;
    }

    @GetMapping
    public List<CurrencyDtoRead> list() {

        List<CurrencyDtoRead> currencyDtoRead = new ArrayList<>();
        for (Currency currency : currencyService.readAll()) {
            currencyDtoRead.add(mapperService.mapRead(currency));
        }
        return currencyDtoRead;
    }

    @GetMapping ("/byName")
    public List<CurrencyDtoRead> listByName(@RequestParam("name") String name) {

        List<CurrencyDtoRead> currencyDtoRead = new ArrayList<>();
        for (Currency currency : currencyService.readAll(name)) {
            currencyDtoRead.add(mapperService.mapRead(currency));
        }
        return currencyDtoRead;
    }

    @GetMapping("/{id}")
    public CurrencyDtoRead read(@PathVariable Long id) {

        return mapperService.mapRead(currencyService.read(id));
    }

    @PostMapping
    public CurrencyDtoRead create (@RequestBody CurrencyDtoCreate dto)
    {
        return mapperService.mapRead(this.currencyService.create(dto));
    }

    @PutMapping("/{id}/version/{version}")
    public CurrencyDtoRead update (@PathVariable Long id, @PathVariable Long version, @RequestBody CurrencyDtoUpdate dto)
    {
        LocalDateTime lastKnowDtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(version), ZoneId.systemDefault());

        this.currencyService.update(id,dto,lastKnowDtUpdate);

        return read(id);
    }

  /*  @DeleteMapping("/{id}/version/{version}")
    public void delete (@PathVariable Long id, @PathVariable Long version)
    {
        LocalDateTime lastKnowDtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(version), ZoneId.systemDefault());
        this.currencyService.delete(id,lastKnowDtUpdate);
    }
   */

}
