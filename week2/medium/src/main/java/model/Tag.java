package model;

import java.util.List;

public class Tag {
    private String title;
    private List<User> userList;

    public Tag() {
    }

    public Tag(String title, List<User> userList) {
        this.title = title;
        this.userList = userList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


}

