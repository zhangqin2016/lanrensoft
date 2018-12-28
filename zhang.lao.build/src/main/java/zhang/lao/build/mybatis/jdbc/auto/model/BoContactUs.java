package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.Date;

public class BoContactUs {
    private String id;

    private String linkName;

    private String linkPhone;

    private String linkSub;

    private String linkContent;

    private Date linkTime;

    private String linkMail;

    private Integer linkState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getLinkSub() {
        return linkSub;
    }

    public void setLinkSub(String linkSub) {
        this.linkSub = linkSub == null ? null : linkSub.trim();
    }

    public String getLinkContent() {
        return linkContent;
    }

    public void setLinkContent(String linkContent) {
        this.linkContent = linkContent == null ? null : linkContent.trim();
    }

    public Date getLinkTime() {
        return linkTime;
    }

    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }

    public String getLinkMail() {
        return linkMail;
    }

    public void setLinkMail(String linkMail) {
        this.linkMail = linkMail == null ? null : linkMail.trim();
    }

    public Integer getLinkState() {
        return linkState;
    }

    public void setLinkState(Integer linkState) {
        this.linkState = linkState;
    }
}