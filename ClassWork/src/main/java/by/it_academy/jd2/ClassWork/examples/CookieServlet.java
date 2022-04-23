package by.it_academy.jd2.ClassWork.examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


    @WebServlet(name = "CookieServlet", urlPatterns = "/cookie")

    public class CookieServlet extends HttpServlet {

        private static final String FIRST_NAME = "firstName";
        private static final String LAST_NAME = "lastName";

        @Override
        protected void doGet(HttpServletRequest req,
                             HttpServletResponse resp)
                throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");

            String firstName =req.getParameter(FIRST_NAME);

            if (firstName == null) {

                Cookie[] cookies = req.getCookies();

                if (cookies != null){

                    String found = null;

                    for (Cookie c : cookies) {
                        if (FIRST_NAME.equalsIgnoreCase(c.getName())) {
                            String value = c.getValue();
                            found = value;
                            break;
                        }
                    }
                    firstName = found;
                }

                if (firstName == null){
                    throw new IllegalArgumentException("Не передан один из обязательных параметров");
                }
            }

            Cookie firstNameCookie = new Cookie(FIRST_NAME, URLEncoder.encode(firstName, StandardCharsets.UTF_8));
            firstNameCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(firstNameCookie);


            String lastName =req.getParameter(LAST_NAME);

            if (lastName == null) {

                Cookie[] cookies = req.getCookies();

                if (cookies != null){

                    String found = null;

                    for (Cookie c : cookies) {
                        if (LAST_NAME.equalsIgnoreCase(c.getName())) {
                            String value = c.getValue();
                            found = value;
                            break;
                        }
                    }
                    lastName = found;
                }

                if (lastName == null){
                    throw new IllegalArgumentException("Не передан один из обязательных параметров");
                }
            }

            Cookie lastNameCookie = new Cookie( LAST_NAME , URLEncoder.encode(lastName, StandardCharsets.UTF_8));
            lastNameCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(lastNameCookie);


            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<p><span style='color: blue;'>Hello, " + " " + lastName + " " + firstName + " " +"!</span></p>");

        }
    }


