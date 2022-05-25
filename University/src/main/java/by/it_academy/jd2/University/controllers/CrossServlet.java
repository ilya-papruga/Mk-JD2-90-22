package by.it_academy.jd2.University.controllers;


import by.it_academy.jd2.University.dto.CrossDto;
import by.it_academy.jd2.University.service.CrossService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CrossServlet", urlPatterns = "/cross")
public class CrossServlet extends HttpServlet {

    private final CrossService crossService;

    private ObjectMapper mapper;

    public CrossServlet() {

        this.crossService = CrossService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        String json = mapper.writeValueAsString(crossService.readAll());

        writer.write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        CrossDto cross = mapper.readValue(req.getInputStream(), CrossDto.class);

        crossService.create(cross);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CrossDto cross = mapper.readValue(req.getInputStream(), CrossDto.class);

        crossService.delete(cross);

    }
}
