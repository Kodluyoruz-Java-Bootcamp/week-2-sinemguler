package dao;

import model.Tag;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<>();

    public void createUser(User user) {
        userList.add(user);
    }

    public List<User> findAllUsers() { //bütün listeyi geri döner
        return userList;
    }


}
