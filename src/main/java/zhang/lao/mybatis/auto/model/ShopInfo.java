package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class ShopInfo {
    private Integer shopId;

    private String uuid;

    private String address;

    private String title;

    private String organizationNo;

    private String taxNo;

    private String businessPic;

    private String organizationPic;

    private String taxPic;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Short type;

    private Short status;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOrganizationNo() {
        return organizationNo;
    }

    public void setOrganizationNo(String organizationNo) {
        this.organizationNo = organizationNo == null ? null : organizationNo.trim();
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    public String getBusinessPic() {
        return businessPic;
    }

    public void setBusinessPic(String businessPic) {
        this.businessPic = businessPic == null ? null : businessPic.trim();
    }

    public String getOrganizationPic() {
        return organizationPic;
    }

    public void setOrganizationPic(String organizationPic) {
        this.organizationPic = organizationPic == null ? null : organizationPic.trim();
    }

    public String getTaxPic() {
        return taxPic;
    }

    public void setTaxPic(String taxPic) {
        this.taxPic = taxPic == null ? null : taxPic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}