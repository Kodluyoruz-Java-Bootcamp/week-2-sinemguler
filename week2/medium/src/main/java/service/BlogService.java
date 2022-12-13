package service;

import dao.BlogDao;
import model.Blog;
import model.User;

import java.util.List;


public class BlogService {
    private BlogDao blogDao = new BlogDao();

    public void createBlog(Blog blog) {
        blogDao.saveBlog(blog);
        System.out.println("createBlog::" + blog.getTitle());
    }

    public List<Blog> getAll() {
        return blogDao.findAll();
    }

    public void printAll(List<Blog> blogList) {
        blogList.forEach(blog -> System.out.println(blog));

//        getAll().forEach(blog -> System.out.println(blog));
    }

    public List<Blog> getAllByUser(User user) { //kullanıcının mailine göre blogları getirir
        return getAll().stream().filter(blog -> blog.getUser().getMail().equals(user.getMail()))
                .toList();
    }
}
