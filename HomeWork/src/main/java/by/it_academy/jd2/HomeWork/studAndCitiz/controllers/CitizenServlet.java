package by.it_academy.jd2.HomeWork.studAndCitiz.controllers;

import by.it_academy.jd2.HomeWork.studAndCitiz.dto.Citizen;
import by.it_academy.jd2.HomeWork.studAndCitiz.service.CitizenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CitizenServlet", urlPatterns = "/citizens")

public class CitizenServlet extends HttpServlet {

    private final CitizenService citizenService;

    private ObjectMapper mapper;

    public CitizenServlet() {
        this.citizenService = CitizenService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        String json = mapper.writeValueAsString(citizenService.getCitizenList());

        writer.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Citizen citizen = mapper.readValue(req.getInputStream(), Citizen.class);

        citizenService.add(citizen);
    }
}
