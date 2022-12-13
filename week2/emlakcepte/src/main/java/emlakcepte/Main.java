package emlakcepte;

import emlakcepte.model.*;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);


        User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
        User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());

        /*
         * UserService userService = UserService.getSameInstance();
         *
         * UserService userService1 = UserService.getSameInstance();
         *
         * UserService userService2 = UserService.getDifferentInstance();
         *
         * System.out.println(userService); System.out.println(userService1);
         * System.out.println(userService2);
         */

        // eski yöntem
        //UserService userService = new UserService();

        //Spring bizim yerime create ediyor
        UserService userService = applicationContext.getBean(UserService.class);

        userService.createUser(userPelin);
        userService.createUser(userSami);

        userService.printAllUser();

        System.out.println("-----");

        // userList.add(user);
        // userList.add(userPelin);

        // userList.forEach(usr -> System.out.println(usr.getName()));

        RealtyService realtyService = new RealtyService();

        Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userPelin,
                RealtyType.ACTIVE, "İstanbul", "Maltepe", RealtyCategory.HOUSING, HousingType.FORSALE);
        realtyService.createRealty(realty);


        Realty realty1 = new Realty();
        realty1.setNo(124L);
        realty1.setTitle("Beşiktaş'da daire");
        realty1.setStatus(RealtyType.ACTIVE);
        realty1.setUser(userPelin);
        realty1.setProvince("İstanbul");
        realty.setDistrict("Beşiktaş");
        realty.setCategory(RealtyCategory.HOUSING);
        realty.setSituation(HousingType.FORRENT);
        realtyService.createRealty(realty1);

        Realty favori1 = new Realty();
        favori1.setNo(125L);
        favori1.setTitle("Keçiören'de daire");
        favori1.setStatus(RealtyType.ACTIVE);
        favori1.setUser(userPelin);
        favori1.setProvince("Ankara");
        realty.setDistrict("Keçiören");
        realty.setCategory(RealtyCategory.HOUSING);
        realty.setSituation(HousingType.FORSALE);
        realtyService.createRealty(favori1);

        Realty realty2 = new Realty();
        realty2.setNo(126L);
        realty2.setTitle("Bornova yeşilova mahallesinde daire");
        realty2.setStatus(RealtyType.ACTIVE);
        realty2.setUser(userSami);
        realty2.setProvince("İzmir");
        realty2.setDistrict("Bornova");
        realty2.setCategory(RealtyCategory.HOUSING);
        realty2.setSituation(HousingType.FORRENT);
        realtyService.createRealty(realty2);

        Realty realty3 = new Realty();
        realty3.setNo(127L);
        realty3.setTitle("Polatlı mahallesinde daire");
        realty3.setStatus(RealtyType.ACTIVE);
        realty3.setUser(userSami);
        realty3.setProvince("Ankara");
        realty3.setDistrict("Polatlı");
        realty3.setCategory(RealtyCategory.HOUSING);
        realty3.setSituation(HousingType.FORRENT);
        realtyService.createRealty(realty3);

        Realty realty4 = new Realty();
        realty4.setNo(128L);
        realty4.setTitle("Kızılay mahallesinde satılık daire");
        realty4.setStatus(RealtyType.ACTIVE);
        realty4.setUser(userSami);
        realty4.setProvince("Ankara");
        realty4.setDistrict("Kızılay");
        realty4.setCategory(RealtyCategory.HOUSING);
        realty4.setSituation(HousingType.FORSALE);
        realtyService.createRealty(realty4);

        Realty realty5 = new Realty();
        realty5.setNo(129L);
        realty5.setTitle("Çeşme'de'arsa");
        realty5.setStatus(RealtyType.ACTIVE);
        realty5.setUser(userPelin);
        realty5.setProvince("İzmir");
        realty5.setDistrict("Çeşme");
        realty5.setCategory(RealtyCategory.LAND);
        realty5.setSituation(HousingType.FORSALE);
        realtyService.createRealty(realty5);

        Realty realty6 = new Realty();
        realty6.setNo(130L);
        realty6.setTitle("Sahibinden deniz manzaralı arsa");
        realty6.setStatus(RealtyType.ACTIVE);
        realty6.setUser(userSami);
        realty6.setProvince("İzmir");
        realty6.setDistrict("Seferihisar");
        realty6.setCategory(RealtyCategory.LAND);
        realty6.setSituation(HousingType.FORRENT);
        realtyService.createRealty(realty6);

        Realty realty7 = new Realty();
        realty7.setNo(131L);
        realty7.setTitle("Arnavutköy'de Arsa");
        realty7.setStatus(RealtyType.PASSIVE);
        realty7.setUser(userPelin);
        realty7.setProvince("İstanbul");
        realty7.setDistrict("Arnavutköy");
        realty7.setCategory(RealtyCategory.LAND);
        realty7.setSituation(HousingType.FORRENT);
        realtyService.createRealty(realty7);

        Realty realty8 = new Realty();
        realty8.setNo(132L);
        realty8.setTitle("Çankaya'da Satılık Arsa");
        realty8.setStatus(RealtyType.DELETED);
        realty8.setUser(userPelin);
        realty8.setProvince("Ankara");
        realty8.setDistrict("Çankaya");
        realty8.setCategory(RealtyCategory.LAND);
        realty8.setSituation(HousingType.FORSALE);
        realtyService.createRealty(realty8);


        realty.setUser(userSami);
        userSami.setRealtyList(List.of(realty, realty1, realty2, realty3, realty4));

        List<Realty> fovarilerim = new ArrayList<>();
        fovarilerim.add(favori1);
        userSami.setFavoriteRealtyList(fovarilerim);

        // sistemdeki bütün ilanlar

        System.out.println("Bütün ilanlar");
        realtyService.printAll(realtyService.getAll());

        // İstanbuldaki ilanların bulunması

        System.out.println("İstanbul'daki ilanlar");
        realtyService.getAllByProvince("İstanbul");

        // Bir kullanıcının bütün ilanlarını listele
        System.out.println("Bir kullanıcının bütün ilanları");
        realtyService.printAll(realtyService.getAllByUserName(userPelin));

        //Bir kullanıcının aktif ilanları
        System.out.println("Bir kullanıcının aktif ilanları");
        realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

        //Şehirlere göre ilan sayısını bulur.
        System.out.println("İstanbul'daki ilan sayısı: " + realtyService.getAllByIstanbul());
        System.out.println("Ankara'daki ilan sayısı: " + realtyService.getAllByAnkara());
        System.out.println("İzmir'deki ilan sayısı: " + realtyService.getAllByIzmir());

        //Şehirlerdeki satılık konut ilanlarının sayısı bulur
        System.out.println("İstanbul'daki satılık ilan sayısı: " + realtyService.getAllBySaleHousingIstanbul());
        System.out.println("Ankara'daki satılık ilan sayısı: " + realtyService.getAllBySaleHousingAnkara());
        System.out.println("İzmir'deki satılık ilan sayısı: " + realtyService.getAllBySaleHousingIzmir());

        //Kullanıcının aradığı ilanlar
        System.out.println("Aranan ilan:" + realtyService.getSearchedRealty("Çankaya'da Satılık Arsa"));
        System.out.println("Aranan şehirdeki ilanlar:" + realtyService.getSearchedProvince("Ankara"));

//        System.out.println("İlçe ilanı");
//        realtyService.getAllByDistrict("Çeşme");

        /*
         * userList.forEach(usr -> {
         *
         * usr.getFavoriteRealtyList().forEach(favoriRealty ->
         * System.out.println(favoriRealty.getTitle()) );
         *
         * });
         */

        Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
                userSami);

        userSami.setMessages(List.of(message));
        userPelin.setMessages(List.of(message));

        userSami.getMessages();


    }

    private static User prepareUser(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setMail(email);
        user.setPassword(password);
        user.setType(UserType.INDIVIDUAL);
        user.setCreateDate(LocalDateTime.now());
        return user;
    }
}