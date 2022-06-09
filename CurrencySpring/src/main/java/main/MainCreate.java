package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.CurrencyDtoCU;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.ICurrencyService;
import service.api.IJacksonService;

import java.util.Scanner;

public class MainCreate {

    public static void main(String[] args) throws JsonProcessingException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("app.xml");

        ICurrencyService currencyService = context.getBean(ICurrencyService.class);
        IJacksonService jacksonService = context.getBean(IJacksonService.class);
        ObjectMapper jacksonMapper = jacksonService.create();

        //  String jsonExample = {"name": "Евро","description":"Европейская валюта","code":"EUR"};

        Scanner scanner = new Scanner(System.in);

        String json = scanner.nextLine();

        CurrencyDtoCU dto = jacksonMapper.readValue(json, CurrencyDtoCU.class);

        currencyService.create(dto);
    }

}
