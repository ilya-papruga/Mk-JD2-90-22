package by.it_academy.jd2.University.controllers.ui;

import by.it_academy.jd2.University.service.JournalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "Journal Servlet", urlPatterns = "/journal")
public class JournalServlet extends HttpServlet {

    private final JournalService journalService;

    private ObjectMapper mapper;

    public JournalServlet() {

        this.journalService = JournalService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        String number = req.getParameter("number");

         if (number != null && !number.isEmpty()) {
             String json = mapper.writeValueAsString(journalService.readJournal(number));
             writer.write(json);
         }
         else {
             String json = mapper.writeValueAsString(journalService.readAll());
             writer.write(json);
         }
    }
}
