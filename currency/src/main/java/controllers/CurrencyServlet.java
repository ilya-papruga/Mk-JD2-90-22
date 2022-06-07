package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.entity.Currency;
import core.dto.CurrencyDtoCU;
import core.dto.CurrencyDtoRead;
import service.CurrencyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CurrencyServlet", urlPatterns = "/currency")
public class CurrencyServlet extends HttpServlet {

    private final CurrencyService currencyService;

    private ObjectMapper mapper;


    public CurrencyServlet() {
        this.currencyService = CurrencyService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String json;
        List<CurrencyDtoRead> currencyDtoRead = new ArrayList<>();

        String rawId = req.getParameter("id");

        if (rawId != null && !rawId.isEmpty()) {

            long id = Long.parseLong(rawId);

            json = mapper.writeValueAsString(mapRead(currencyService.read(id)));

        } else {

            for (Currency currency : currencyService.readAll()) {
                currencyDtoRead.add(mapRead(currency));
            }

            json = mapper.writeValueAsString(currencyDtoRead);
        }
        writer.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        CurrencyDtoCU dto = mapper.readValue(req.getInputStream(), CurrencyDtoCU.class);
        currencyService.create(dto);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String rawId = (req.getParameter("id"));

        if (rawId != null && !rawId.isEmpty()) {
            long id = Long.parseLong(rawId);
            CurrencyDtoCU dto = mapper.readValue(req.getInputStream(), CurrencyDtoCU.class);
            currencyService.update(id, dto);
            writer.write("Информация успешно обновлена");
        } else {

            writer.write("Введите id студента для обновления информации");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String rawId = (req.getParameter("id"));

        if (rawId != null && !rawId.isEmpty()) {
            long id = Long.parseLong(rawId);
            currencyService.delete(id);
            writer.write("Запись " + id + " успешна удалёна");
        } else {
            writer.write("Введите корректный id записи для удаления");
        }
    }


    private CurrencyDtoRead mapRead(Currency currency) {

        CurrencyDtoRead currencyDtoRead = new CurrencyDtoRead();

        currencyDtoRead.setId(currency.getId());
        currencyDtoRead.setDtCreate(currency.getDtCreate());
        currencyDtoRead.setDtUpdate(currency.getDtUpdate());
        currencyDtoRead.setName(currency.getName());
        currencyDtoRead.setDescription(currency.getDescription());
        currencyDtoRead.setCode(currency.getCode());
        return currencyDtoRead;
    }
}
