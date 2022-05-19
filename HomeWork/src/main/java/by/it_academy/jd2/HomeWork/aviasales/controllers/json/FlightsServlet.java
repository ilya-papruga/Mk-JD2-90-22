package by.it_academy.jd2.HomeWork.aviasales.controllers.json;


import by.it_academy.jd2.HomeWork.aviasales.controllers.json.dto.Page;
import by.it_academy.jd2.HomeWork.aviasales.controllers.utils.PaginationUtils;
import by.it_academy.jd2.HomeWork.aviasales.dao.Flights;
import by.it_academy.jd2.HomeWork.aviasales.dao.FlightsFilter;
import by.it_academy.jd2.HomeWork.aviasales.dao.Pageable;
import by.it_academy.jd2.HomeWork.aviasales.service.AirportService;
import by.it_academy.jd2.HomeWork.aviasales.service.FlightsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "FlightsServletJson", urlPatterns = "/json/aviasales/flights")
public class FlightsServlet extends HttpServlet {

    private final FlightsService flightsService;
    private final AirportService airportsService;

    private ObjectMapper mapper;


    public FlightsServlet() {

        this.flightsService = FlightsService.getInstance();
        this.airportsService = AirportService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        FlightsFilter.Builder builder = FlightsFilter.Builder.create();

        String arrivalAirportRaw = req.getParameter("arrivalAirport");

        if (arrivalAirportRaw != null && !arrivalAirportRaw.isEmpty()) {

            builder.setArrivalAirport(arrivalAirportRaw);
        }

        String departureAirportRaw = req.getParameter("departureAirport");

        if (departureAirportRaw != null && !departureAirportRaw.isEmpty()) {

            builder.setDepartureAirport(departureAirportRaw);
        }

        FlightsFilter filter = builder.build();

        String pageRaw = req.getParameter("page");
        String sizeRaw = req.getParameter("size");

        int page = 1;
        int size = 50;

        if (pageRaw != null && !pageRaw.isEmpty()) {
            page = Integer.parseInt(pageRaw);
        }

        if (sizeRaw != null && !sizeRaw.isEmpty()) {
            size = Integer.parseInt(sizeRaw);
        }

        Pageable pageable = Pageable.of(size, page);


        long totalElements = this.flightsService.count(filter);

        PrintWriter writer = resp.getWriter();

        Page <Flights> flightsPage = Page.Builder.create(Flights.class)
                .setPage(pageable.getPage())
                .setSize(pageable.getSize())
                .setTotalElements(totalElements)
                .setContent(this.flightsService.list(filter, pageable))
                        .build();

        writer.write(mapper.writeValueAsString(flightsPage));
    }

}
