package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class MemberBind {
    private Long mbId;

    private Long uId;

    private String bindType;

    private String keyid;

    private Date createTime;

    private Short status;

    public Long getMbId() {
        return mbId;
    }

    public void setMbId(Long mbId) {
        this.mbId = mbId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType == null ? null : bindType.trim();
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid == null ? null : keyid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}