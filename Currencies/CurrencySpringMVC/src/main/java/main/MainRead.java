package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.CurrencyDtoR;
import core.entity.Currency;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.ICurrencyService;
import service.api.IJacksonService;
import service.api.IMapperService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRead {


    public static void main(String[] args) throws JsonProcessingException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-servlet.xml");

        ICurrencyService currencyService = context.getBean(ICurrencyService.class);
        IMapperService mapperService = context.getBean(IMapperService.class);
        IJacksonService jacksonService = context.getBean(IJacksonService.class);
        ObjectMapper jacksonMapper = jacksonService.create();

        Scanner scanner = new Scanner(System.in);

        List<CurrencyDtoR> currencyDtoR = new ArrayList<>();

        String json;

        System.out.println("Введите id для выбора валюты");
        System.out.println("Для отображения списка всех валют отправьте пустой запрос");

        String rawId = scanner.nextLine();

        if (rawId != null && !rawId.isEmpty()) {

            long id = Long.parseLong(rawId);
            json = jacksonMapper.writeValueAsString(mapperService.mapRead(currencyService.read(id)));

        } else {

            for (Currency currency : currencyService.readAll()) {
                currencyDtoR.add(mapperService.mapRead(currency));
            }

            json = jacksonMapper.writeValueAsString(currencyDtoR);
        }

        String beautyJson = json.replaceAll("\\},\\{", "},\n{");

        System.out.println(beautyJson);
    }
}
