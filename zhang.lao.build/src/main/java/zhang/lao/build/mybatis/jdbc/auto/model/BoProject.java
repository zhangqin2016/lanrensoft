package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.Date;

public class BoProject {
    private String id;

    private String type;

    private String selfBuild;

    private String title;

    private String projectDevelopers;

    private Date projectInto;

    private String projrctManager;

    private Integer projectEstate;

    private String province;

    private String city;

    private String country;

    private String address;

    private String decorationLeave;

    private String imageCover;

    private Integer state;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSelfBuild() {
        return selfBuild;
    }

    public void setSelfBuild(String selfBuild) {
        this.selfBuild = selfBuild == null ? null : selfBuild.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProjectDevelopers() {
        return projectDevelopers;
    }

    public void setProjectDevelopers(String projectDevelopers) {
        this.projectDevelopers = projectDevelopers == null ? null : projectDevelopers.trim();
    }

    public Date getProjectInto() {
        return projectInto;
    }

    public void setProjectInto(Date projectInto) {
        this.projectInto = projectInto;
    }

    public String getProjrctManager() {
        return projrctManager;
    }

    public void setProjrctManager(String projrctManager) {
        this.projrctManager = projrctManager == null ? null : projrctManager.trim();
    }

    public Integer getProjectEstate() {
        return projectEstate;
    }

    public void setProjectEstate(Integer projectEstate) {
        this.projectEstate = projectEstate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDecorationLeave() {
        return decorationLeave;
    }

    public void setDecorationLeave(String decorationLeave) {
        this.decorationLeave = decorationLeave == null ? null : decorationLeave.trim();
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover == null ? null : imageCover.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}