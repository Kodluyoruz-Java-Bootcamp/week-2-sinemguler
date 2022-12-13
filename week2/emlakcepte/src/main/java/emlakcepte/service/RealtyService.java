package emlakcepte.service;

import emlakcepte.dao.RealtyDao;
import emlakcepte.model.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

@Service
public class RealtyService {
    private RealtyDao realtyDao = new RealtyDao();

    @Autowired //injection
    private UserService userService;

    public void createRealty(Realty realty) {

        //userService.printAllUser();

        if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
            // en fazla 5 ilan girebilir.
            //&& RealtyCategory.HOUSING.equals(realty.getCategory())
            System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");
        }

        realtyDao.saveRealty(realty);
        System.out.println("createRealty :: " + realty.getTitle());
    }

    public List<Realty> getAll() {
        return realtyDao.findAll();
    }

    public void printAll(List<Realty> realtyList) {
        realtyList.forEach(realty -> System.out.println(realty));
    }

    public void getAllByProvince(String province) {
        getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                //.count();
                .forEach(realty -> System.out.println(realty));
    }

    public List<Realty> getAllByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getMail().equals(user.getMail()))
                .toList();
    }

    public List<Realty> getActiveRealtyByUserName(User user) {
        return getAll().stream()
                .filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
                .toList();

    }

    public long getAllByIstanbul() { //şehirlere göre ilan sayısı
        return getAll().stream().filter(realty -> realty.getProvince().equals("İstanbul")).count();
    }

    public long getAllByAnkara() {
        return getAll().stream().filter(realty -> realty.getProvince().equals("Ankara")).count();
    }

    public long getAllByIzmir() {
        return getAll().stream().filter(realty -> realty.getProvince().equals("İzmir")).count();
    }

    public long getAllBySaleHousingIstanbul() { //şehirlere göre satılık ilan sayısı
        return getAll().stream().filter(realty -> realty.getProvince().equals("İstanbul") && HousingType.FORSALE.equals(realty.getSituation())).count();
    }

    public long getAllBySaleHousingAnkara() {
        return getAll().stream().filter(realty -> realty.getProvince().equals("Ankara") && HousingType.FORSALE.equals(realty.getSituation())).count();
    }

    public long getAllBySaleHousingIzmir() {
        return getAll().stream().filter(realty -> realty.getProvince().equals("İzmir") && HousingType.FORSALE.equals(realty.getSituation())).count();
    }

    public List<Realty> getSearchedRealty(String title) { //ilanları aramak için gerekli kod
        return getAll().stream()
                .filter(realty -> realty.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public void listRealty() {
        getAll().stream().
                forEach(realty -> System.out.println(realty.getTitle()));
    }

    public List<Realty> getSearchedProvince(String province) { //ilanları aramak için gerekli kod
        return getAll().stream()
                .filter(realty -> realty.getProvince().contains(province))
                .collect(Collectors.toList());
    }

    public void listRealtyProvince() {
        getAll().stream()
                .forEach(realty -> System.out.println(realty.getProvince()));
    }

//    public void getAllByDistrict(String district) {
//
//        getAll().stream()
//                .filter(realty -> realty.getDistrict().equals(district))
//                .forEach(realty -> System.out.println(realty));
//    }
}
