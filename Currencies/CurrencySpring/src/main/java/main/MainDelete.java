package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.api.ICurrencyService;

import java.util.Scanner;

public class MainDelete {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-servlet.xml");

        ICurrencyService currencyService = context.getBean(ICurrencyService.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id для удаления");
        String rawId = scanner.nextLine();

        if (rawId != null && !rawId.isEmpty()) {
            long id = Long.parseLong(rawId);
            currencyService.delete(id);
            System.out.println("Запись " + id + " успешна удалёна");

        } else {
            System.out.println("Введите корректный id записи для удаления");
        }

    }

}
