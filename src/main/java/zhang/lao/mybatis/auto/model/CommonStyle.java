package zhang.lao.mybatis.auto.model;

public class CommonStyle {
    private Integer csId;

    private String name;

    private String showImg;

    private String selectedImg;

    private Short sort;

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
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