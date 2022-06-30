package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.dto.CurrencyDtoCreate;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

public class Main {

    public static void mainSelect(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://127.0.0.1:8080/currency-1.0-SNAPSHOT/currency";
        String currencyDTO = restTemplate.getForObject(fooResourceUrl, String.class);
        System.out.println(currencyDTO);
    }

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        CurrencyDtoCreate dto = new CurrencyDtoCreate();

        dto.setName("Dollar");
        dto.setCode("USD");
        dto.setDescription("Американский доллар");

        String fooResourceUrl = "http://127.0.0.1:8080/currency-1.0-SNAPSHOT/currency";


        HttpEntity<CurrencyDtoCreate> request = new HttpEntity<>(dto);

      //  CurrencyDtoCreate dtoCreate = restTemplate.postForObject(fooResourceUrl, request, CurrencyDtoCreate.class);

        URI location = restTemplate.postForLocation(fooResourceUrl, request);

    }

    public static void mainUUID(String[] args) {

        System.out.println(UUID.randomUUID());

    }

}
