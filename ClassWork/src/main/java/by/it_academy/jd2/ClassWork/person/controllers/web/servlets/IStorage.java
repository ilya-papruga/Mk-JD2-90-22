package by.it_academy.jd2.ClassWork.person.controllers.web.servlets;

import by.it_academy.jd2.ClassWork.person.core.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IStorage {

    void save(HttpServletRequest req, HttpServletResponse resp, Person person);

    Person get (HttpServletRequest req);

}
