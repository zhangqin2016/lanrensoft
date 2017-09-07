package zhang.lao.build.mybatis.jdbc.auto.model;

import java.math.BigDecimal;

public class BoProjectGoods {
    private String id;

    private String title;

    private BigDecimal buildArea;

    private BigDecimal equityPrice;

    private BigDecimal adminPrice;

    private String imageCover;

    private String tag;

    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public BigDecimal getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(BigDecimal buildArea) {
        this.buildArea = buildArea;
    }

    public BigDecimal getEquityPrice() {
        return equityPrice;
    }

    public void setEquityPrice(BigDecimal equityPrice) {
        this.equityPrice = equityPrice;
    }

    public BigDecimal getAdminPrice() {
        return adminPrice;
    }

    public void setAdminPrice(BigDecimal adminPrice) {
        this.adminPrice = adminPrice;
    }

    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover == null ? null : imageCover.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}