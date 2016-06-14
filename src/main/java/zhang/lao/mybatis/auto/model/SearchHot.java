package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class SearchHot {
    private Long id;

    private String keyworld;

    private Integer count;

    private Date statisticDate;

    private Integer modId;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyworld() {
        return keyworld;
    }

    public void setKeyworld(String keyworld) {
        this.keyworld = keyworld == null ? null : keyworld.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStatisticDate() {
        return statisticDate;
    }

    public void setStatisticDate(Date statisticDate) {
        this.statisticDate = statisticDate;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}