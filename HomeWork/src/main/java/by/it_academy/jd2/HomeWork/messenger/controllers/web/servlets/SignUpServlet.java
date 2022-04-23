package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SignUpServlet", urlPatterns = "/ui/SignUp")
public class SignUpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");
        req.getRequestDispatcher("/ui/SignUp.jsp").forward(req, resp);


    }


}
