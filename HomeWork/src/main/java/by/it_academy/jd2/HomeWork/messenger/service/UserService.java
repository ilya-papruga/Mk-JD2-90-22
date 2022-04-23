package by.it_academy.jd2.HomeWork.messenger.service;

import by.it_academy.jd2.HomeWork.messenger.core.dto.RoleType;
import by.it_academy.jd2.HomeWork.messenger.core.dto.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserService {


    private static final UserService instance = new UserService();
    private Map<String, User> savedUsers = new HashMap<>();
    private StatisticsService service;


    User admin = new User(
            "ilya.papruga",
            "123567",
            "Ilya Papruga Vitalevich",
            "15.02.1993",
            LocalDateTime.now(),
            RoleType.ADMIN);

    public UserService() {
        this.service = StatisticsService.getInstance();
        savedUsers.put(admin.getLogin(),admin);
    }

    public void save(User user) {
        user.setRegDate(LocalDateTime.now());
        user.setRole(RoleType.USER);
        savedUsers.put(user.getLogin(), user);
        service.incUsersCount();
    }

    public boolean check(String login, String password)
    {

        User checkUser = savedUsers.get(login);
        boolean loginStatus = false;

        if (checkUser != null)
        {
            if (checkUser.getPassword().equals(password)) {
                loginStatus = true;
            }
        }

        return loginStatus;

    }

    public Map<String, User> getSavedUsers() {
        return savedUsers;
    }

    public static UserService getInstance() {
        return instance;
    }

}
