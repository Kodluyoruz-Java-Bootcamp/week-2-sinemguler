package emlakcepte.model;

import java.time.LocalDateTime;

public class Realty {
    private Long no;
    private String title;
    private LocalDateTime publishedDate;
    private User user;
    private RealtyType status; //silinmiş,aktif,pasif
    private String province;
    private String district;

    private RealtyCategory category; //ev,arsa

    private HousingType situation; //satılık,kiralık

    public Realty() {
        super();
    }

    public Realty(Long no, String title, LocalDateTime publishedDate, User user, RealtyType status, String province, String district, RealtyCategory category, HousingType situation) {
        super();
        this.no = no;
        this.title = title;
        this.publishedDate = publishedDate;
        this.user = user;
        this.status = status;
        this.province = province;
        this.district = district;
        this.category = category;
        this.situation = situation;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RealtyType getStatus() {
        return status;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public RealtyCategory getCategory() {
        return category;
    }

    public void setCategory(RealtyCategory category) {
        this.category = category;
    }

    public HousingType getSituation() {
        return situation;
    }

    public void setSituation(HousingType situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Realty [no=" + no + ", title=" + title + ", publishedDate=" + publishedDate + ", user=" + user
                + ", status=" + getStatus() + ", province=" + province + ", district=" + district + ", category=" + getCategory() + ", situation=" + getSituation() + "]";
    }

}
