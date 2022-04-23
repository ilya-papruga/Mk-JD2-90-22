package by.it_academy.jd2.ClassWork.examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")

public class SessionServlet extends HttpServlet {


    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");


        String firstName =req.getParameter(FIRST_NAME);

        if (firstName == null) {

            HttpSession session = req.getSession();

            if(!session.isNew()) {
                firstName = (String) session.getAttribute(FIRST_NAME);
            }
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute(FIRST_NAME, firstName);
        }


        if (firstName == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }



        String lastName =req.getParameter(LAST_NAME);

        HttpSession session = req.getSession();
        if (lastName == null){

            if(!session.isNew()) {
                lastName = (String) session.getAttribute(LAST_NAME);
            }
        }
        else {
            session.setAttribute(LAST_NAME, lastName);
        }



        if (lastName == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }


        PrintWriter writer = resp.getWriter();

        writer.write("<p><span style='color: blue;'>Hello, " + " " + firstName + " " + lastName + " " +"!</span></p>");





    }
}
