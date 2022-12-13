package model;

public class Blog {
    private int id;
    private String title;
    private String content;
    private BlogType status;
    private User user;

    public Blog() {
    }

    public Blog(int id, String title, String content, BlogType status, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogType getStatus() {
        return status;
    }

    public void setStatus(BlogType status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

}
