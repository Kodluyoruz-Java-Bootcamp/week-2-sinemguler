package model;

import service.TagService;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String name;
    private String biography;
    private String mail;
    private String password;
    private List<Blog> blogList;
    private List<User> followUserList;
    private List<Tag> tagList;
    private LocalDateTime createDate;
    private List<Following> followings;


    public User() {
    }

    public User(String name, String biography, String mail, String password, List<Blog> blogList,List<Tag> tagList) {
        this.name = name;
        this.biography = biography;
        this.mail = mail;
        this.password = password;
        this.blogList = blogList;
        this.tagList = tagList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public List<User> getFollowUserList() {
        return followUserList;
    }

    public void setFollowUserList(List<User> followUserList) {
        this.followUserList = followUserList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Following> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Following> followings) {
        this.followings = followings;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                '}';
    }


}
