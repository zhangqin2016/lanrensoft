package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class LogFitting {
    private Long id;

    private Long goodsId;

    private String sex;

    private String brand;

    private String type;

    private String style;

    private String color;

    private String shoulderBreadth;

    private String hipline;

    private String waistline;

    private String bust;

    private String weight;

    private String height;

    private String size;

    private Integer standingTime;

    private String deviceType;

    private String deviceKey;

    private Date createTime;

    private String appUuid;

    private Integer uId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getShoulderBreadth() {
        return shoulderBreadth;
    }

    public void setShoulderBreadth(String shoulderBreadth) {
        this.shoulderBreadth = shoulderBreadth == null ? null : shoulderBreadth.trim();
    }

    public String getHipline() {
        return hipline;
    }

    public void setHipline(String hipline) {
        this.hipline = hipline == null ? null : hipline.trim();
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline == null ? null : waistline.trim();
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust == null ? null : bust.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getStandingTime() {
        return standingTime;
    }

    public void setStandingTime(Integer standingTime) {
        this.standingTime = standingTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAppUuid() {
        return appUuid;
    }

    public void setAppUuid(String appUuid) {
        this.appUuid = appUuid == null ? null : appUuid.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}