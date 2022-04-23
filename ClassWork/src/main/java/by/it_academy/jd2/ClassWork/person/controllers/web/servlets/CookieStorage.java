package by.it_academy.jd2.ClassWork.person.controllers.web.servlets;

import by.it_academy.jd2.ClassWork.person.core.dto.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CookieStorage implements IStorage {

    private static final String COOKIES_FIRSTNAME_NAME = "firstName";
    private static final String COOKIES_LASTNAME_NAME = "lastName";
    private static final String COOKIES_AGE_NAME = "age";

    @Override
    public void save(HttpServletRequest req, HttpServletResponse resp, Person person) {


        Cookie firstNameCookie = new Cookie(COOKIES_FIRSTNAME_NAME, URLEncoder.encode(person.getFirstName(), StandardCharsets.UTF_8));
        Cookie lastNameCookie = new Cookie(COOKIES_LASTNAME_NAME, URLEncoder.encode(person.getLastName(), StandardCharsets.UTF_8));
        Cookie AgeCookie = new Cookie(COOKIES_AGE_NAME, URLEncoder.encode(String.valueOf(person.getAge()), StandardCharsets.UTF_8));

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);
        resp.addCookie(AgeCookie);

    }

    @Override
    public Person get(HttpServletRequest req) {
        String firstName = getCookie(req, COOKIES_FIRSTNAME_NAME);
        String lastName = getCookie(req, COOKIES_LASTNAME_NAME);
        String ageRaw = getCookie(req, COOKIES_AGE_NAME);

        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(Integer.parseInt(ageRaw));

        return p;
    }


    private static String getCookie(HttpServletRequest req, String name) {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {

                /*
                         Cookie cookie = Arrays.stream(cookies)
                        .filter(c -> c.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .orElse(null);
                 */

            Cookie cookie = null;
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase(name)) {
                    cookie = c;
                    break;
                }
            }

            if (cookies != null) {
                return URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
            }

        }
        return null;
}
}
