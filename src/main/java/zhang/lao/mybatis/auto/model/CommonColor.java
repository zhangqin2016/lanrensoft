package zhang.lao.mybatis.auto.model;

public class CommonColor {
    private Integer id;

    private Integer shopId;

    private Integer pid;

    private String name;

    private String colorImg;

    private Short srot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getColorImg() {
        return colorImg;
    }

    public void setColorImg(String colorImg) {
        this.colorImg = colorImg == null ? null : colorImg.trim();
    }

    public Short getSrot() {
        return srot;
    }

    public void setSrot(Short srot) {
        this.srot = srot;
    }
}