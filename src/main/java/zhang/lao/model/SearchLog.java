package zhang.lao.model;

import java.util.Date;

public class SearchLog {
    private Integer id;

    private Long uId;

    private String keyworld;

    private Date createTime;

    private Integer modId;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getKeyworld() {
        return keyworld;
    }

    public void setKeyworld(String keyworld) {
        this.keyworld = keyworld == null ? null : keyworld.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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