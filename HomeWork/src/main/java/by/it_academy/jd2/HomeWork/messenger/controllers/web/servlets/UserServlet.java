package by.it_academy.jd2.HomeWork.messenger.controllers.web.servlets;

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

@WebServlet(name="UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {

    private UserService service;

    public UserServlet(){
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

        service.save(user);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("html/text; charset=utf-8");

        PrintWriter writer = resp.getWriter();

       // List<String> logins = new ArrayList<>(service.getSavedUsers().keySet());

       // writer.write(service.getSavedUsers().keySet().toString());
/*
        for (SavedUser savedUser : service.getSavedUsers()) {

            writer.write("<p>" + savedUser.getUser().getLogin() + "</p></br>");
            writer.write("<p>" + savedUser.getUser().getPassword() + "</p></br>");
            writer.write("<p>" + savedUser.getUser().getFullName() + "</p></br>");
            writer.write("<p>" + savedUser.getUser().getBirthDate() + "</p></br>");
            writer.write("<p>" + savedUser.getDtCreate() + "</p></br>");
            writer.write("<p>" + savedUser.getType() + "</p></br>");
        }

 */

        for (Map.Entry<String,User> entry : service.getSavedUsers().entrySet()) {
            writer.write("Key: " + entry.getKey() + "</br>" +
                    " Value: " + entry.getValue().toString() + "</br>" + "</br>");
        }



    }
}
