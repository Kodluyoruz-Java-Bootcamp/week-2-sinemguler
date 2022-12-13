package service;

import dao.UserDao;
import model.Tag;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public void createUser(User user) {
        if (user.getPassword().length() < 5) {
            System.out.println("Password must be at least 5 characters!");
        }
        userDao.createUser(user);
    }

    public List<User> getAllUser() {
        return userDao.findAllUsers();
    }

    public void printAllUser() { //bütün userları getiren metod
        getAllUser().forEach(user -> System.out.println(user.getName()));
    }


}
