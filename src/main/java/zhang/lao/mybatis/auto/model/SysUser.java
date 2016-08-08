package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class SysUser {
    private Long suId;

    private String userName;

    private String nickName;

    private String userPassword;

    private String userPic;

    private Short verifyEmail;

    private String phone;

    private String email;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private String uuid;

    private Short userType;

    private Short isAuth;

    private Short status;

    public Long getSuId() {
        return suId;
    }

    public void setSuId(Long suId) {
        this.suId = suId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }

    public Short getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(Short verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Short isAuth) {
        this.isAuth = isAuth;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}