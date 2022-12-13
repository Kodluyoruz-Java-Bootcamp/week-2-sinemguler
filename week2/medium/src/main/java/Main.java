import model.*;
import service.BlogService;
import service.TagService;
import service.UserService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user2 = prepareUser("Ayşe", "Yazılımcı", "ayse@gmail.com", "987456");
        User user1 = prepareUser("Cem", "Öğretmen", "cem@gmail.com", "123456");

        UserService userService = new UserService();
        userService.createUser(user1);
        userService.createUser(user2);
        userService.printAllUser();

        System.out.println("----------------");

        BlogService blogService = new BlogService();

        Blog blog1 = new Blog();
        blog1.setId(1);
        blog1.setTitle("Yazılım");
        blog1.setContent("Yazılımda kullanılan teknolojiler");
        blog1.setStatus(BlogType.PUBLISHED);
        blog1.setUser(user1);
        blogService.createBlog(blog1);

        Blog blog2 = new Blog();
        blog2.setId(2);
        blog2.setTitle("İşlemci");
        blog2.setContent("En iyi işlemciler");
        blog2.setStatus(BlogType.DRAFT);
        blog2.setUser(user1);
        blogService.createBlog(blog2);

        Blog blog3 = new Blog();
        blog3.setId(3);
        blog3.setTitle("Bilgisayar");
        blog3.setContent("Bilgisayar mühendisleri için bilgisayar önerileri");
        blog3.setStatus(BlogType.DELETED);
        blog3.setUser(user2);
        blogService.createBlog(blog3);

        user1.setBlogList(List.of(blog1, blog2)); //user1 kullanıcımızın 2 blogu var biri taslak biri yayınlanmış
        user2.setBlogList(List.of(blog3));
        System.out.println("----------------");

        TagService tagService = new TagService();

        Tag tag1 = new Tag();
        tag1.setTitle("Teknoloji");
        tagService.createTag(tag1);

        Tag tag2 = new Tag();
        tag2.setTitle("Bilim");
        tagService.createTag(tag2);
        System.out.println("----------------");

        //sistemdeki bütün blogları listeler
        blogService.printAll(blogService.getAll());
        System.out.println("----------------");

        //kullanıcıların yayınladıkları blogları listeler
        blogService.printAll(blogService.getAllByUser(user1));
        System.out.println("----------------");

        Following following = new Following("takip edilenler", user1, user2);
        user1.setFollowings(List.of(following));
        user2.setFollowings(List.of(following));
        user1.getFollowings();





//        List<User> followUsers = new ArrayList<>();
//        followUsers.add(user2);
//        user.setFollowUserList(followUsers);
//
//        userList.forEach(user1 -> {
//            user1.getFollowUserList().forEach(followUsr ->
//                    System.out.println(followUsr.getName()));
//        });
//        System.out.println("takip edilen"+ followUsers);

    }


    private static User prepareUser(String name, String biography, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setBiography(biography);
        user.setMail(email);
        user.setPassword(password);
        user.setCreateDate(LocalDateTime.now());
        return user;
    }
}