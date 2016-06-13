package zhang.lao.model;

import java.util.Date;

public class MemberFans {
    private Long mfId;

    private Long uId;

    private Long fansUid;

    private Date createTime;

    public Long getMfId() {
        return mfId;
    }

    public void setMfId(Long mfId) {
        this.mfId = mfId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getFansUid() {
        return fansUid;
    }

    public void setFansUid(Long fansUid) {
        this.fansUid = fansUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}