package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets.api;

import by.it_academy.jd2.HomeWork.messenger.core.dto.User;
import by.it_academy.jd2.HomeWork.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private UserService service;
    public UserServlet() {
        this.service = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String birthDate = req.getParameter("birthDate");

        User user = new User(login, password, fullName, birthDate);

        if (service.checkSignUp(user)) {
            service.save(user);
            resp.sendRedirect(req.getContextPath() + "/ui?success=Registration completed successfully");
        }
        else
        {
            resp.sendRedirect(req.getContextPath() +
                    "/ui/SignUp?error=The selected login is already registered." +
                    " Choose a different login.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        // Вывод юзеров
        /* for (Map.Entry<String,User> entry : service.getSavedUsers().entrySet()) {
            writer.write("Key: " + entry.getKey() + "</br>" +
                    " Value: " + entry.getValue().toString() + "</br>" + "</br>");
        }
         */

    }
}
