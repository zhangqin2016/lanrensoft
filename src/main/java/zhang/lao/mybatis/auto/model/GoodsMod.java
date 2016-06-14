package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class GoodsMod {
    private Integer mgmId;

    private Long goodsId;

    private Integer shopId;

    private String modUrl;

    private String frontUrl;

    private String reverseUrl;

    private String terminal;

    private Date createTime;

    private Integer createUserId;

    private Date updateTime;

    private Integer updateUserId;

    private Short status;

    private String md5Code;

    public Integer getMgmId() {
        return mgmId;
    }

    public void setMgmId(Integer mgmId) {
        this.mgmId = mgmId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getModUrl() {
        return modUrl;
    }

    public void setModUrl(String modUrl) {
        this.modUrl = modUrl == null ? null : modUrl.trim();
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl == null ? null : frontUrl.trim();
    }

    public String getReverseUrl() {
        return reverseUrl;
    }

    public void setReverseUrl(String reverseUrl) {
        this.reverseUrl = reverseUrl == null ? null : reverseUrl.trim();
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal == null ? null : terminal.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code == null ? null : md5Code.trim();
    }
}