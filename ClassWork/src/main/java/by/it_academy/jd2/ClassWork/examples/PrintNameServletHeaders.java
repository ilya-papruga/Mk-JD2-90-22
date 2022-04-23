package by.it_academy.jd2.ClassWork.examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "PrintNameServletHeaders", urlPatterns = "/test_headers")
public class PrintNameServletHeaders extends HttpServlet {


    private String NAME_PARAM_HEADER = "ARRAY_NAME_PARAM";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String header = req.getHeader(NAME_PARAM_HEADER);

        String [] names = req.getParameterMap().get(header);

        if (names != null)
            for (String name : names) {

                writer.write("<p>" + header + ": " + name + "</p>");

            }
    }
}
