package by.it_academy.jd2.HomeWork.studAndCitiz.controllers;

import by.it_academy.jd2.HomeWork.studAndCitiz.dto.Student;
import by.it_academy.jd2.HomeWork.studAndCitiz.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StudentsServlet", urlPatterns = "/students")

public class StudentsServlet extends HttpServlet {

    private final StudentService studentService;

    private ObjectMapper mapper;

    public StudentsServlet() {
        this.studentService = StudentService.getInstance();
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        String json = mapper.writeValueAsString(studentService.getStudentList());

        writer.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Student student = mapper.readValue(req.getInputStream(), Student.class);

        studentService.add(student);
    }
}
