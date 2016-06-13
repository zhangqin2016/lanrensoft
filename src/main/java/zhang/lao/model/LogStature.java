package zhang.lao.model;

import java.util.Date;

public class LogStature {
    private Long id;

    private String sex;

    private String shoulderBreadth;

    private String hipline;

    private String waistline;

    private String bust;

    private String weight;

    private String height;

    private String size;

    private String deviceType;

    private String deviceKey;

    private Date createTime;

    private String appUuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
}