package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.dto.CurrencyDtoCU;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.ICurrencyService;
import service.api.IJacksonService;

import java.util.Scanner;

public class MainUpdate {

    public static void main(String[] args) throws JsonProcessingException {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-servlet.xml");


        ICurrencyService currencyService = context.getBean(ICurrencyService.class);
        IJacksonService jacksonService = context.getBean(IJacksonService.class);
        ObjectMapper jacksonMapper = jacksonService.create();



        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id для обновления");
        String rawId = scanner.nextLine();

        System.out.println("Введите обновлённую информацию");
        String json = scanner.nextLine();


        if (rawId != null && !rawId.isEmpty()) {
            long id = Long.parseLong(rawId);
            CurrencyDtoCU dto = jacksonMapper.readValue(json, CurrencyDtoCU.class);
            currencyService.update(id, dto);
            System.out.println("Информация успешно обновлена");
        } else {
            System.out.println("Введите корректный id для обновления");
        }
    }
    }


