package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class MemberLog {
    private Long mlId;

    private Long uId;

    private Date createTime;

    private String type;

    private String userAgent;

    private String content;

    public Long getMlId() {
        return mlId;
    }

    public void setMlId(Long mlId) {
        this.mlId = mlId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}