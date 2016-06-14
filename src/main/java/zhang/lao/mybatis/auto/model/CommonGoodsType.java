package zhang.lao.mybatis.auto.model;

public class CommonGoodsType {
    private Integer id;

    private Integer pid;

    private String sex;

    private String name;

    private String showImg;

    private String selectedImg;

    private Short sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg == null ? null : showImg.trim();
    }

    public String getSelectedImg() {
        return selectedImg;
    }

    public void setSelectedImg(String selectedImg) {
        this.selectedImg = selectedImg == null ? null : selectedImg.trim();
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }
}