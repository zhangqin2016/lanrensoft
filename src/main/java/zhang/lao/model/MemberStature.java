package zhang.lao.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberStature {
    private Long msId;

    private Long uId;

    private String uSex;

    private String modSize;

    private BigDecimal modHeight;

    private BigDecimal modBust;

    private BigDecimal modWaist;

    private BigDecimal modHip;

    private BigDecimal modWeight;

    private BigDecimal modShoulder;

    private BigDecimal armLen;

    private BigDecimal modThigh;

    private BigDecimal legLen;

    private Date createTime;

    public Long getMsId() {
        return msId;
    }

    public void setMsId(Long msId) {
        this.msId = msId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public String getModSize() {
        return modSize;
    }

    public void setModSize(String modSize) {
        this.modSize = modSize == null ? null : modSize.trim();
    }

    public BigDecimal getModHeight() {
        return modHeight;
    }

    public void setModHeight(BigDecimal modHeight) {
        this.modHeight = modHeight;
    }

    public BigDecimal getModBust() {
        return modBust;
    }

    public void setModBust(BigDecimal modBust) {
        this.modBust = modBust;
    }

    public BigDecimal getModWaist() {
        return modWaist;
    }

    public void setModWaist(BigDecimal modWaist) {
        this.modWaist = modWaist;
    }

    public BigDecimal getModHip() {
        return modHip;
    }

    public void setModHip(BigDecimal modHip) {
        this.modHip = modHip;
    }

    public BigDecimal getModWeight() {
        return modWeight;
    }

    public void setModWeight(BigDecimal modWeight) {
        this.modWeight = modWeight;
    }

    public BigDecimal getModShoulder() {
        return modShoulder;
    }

    public void setModShoulder(BigDecimal modShoulder) {
        this.modShoulder = modShoulder;
    }

    public BigDecimal getArmLen() {
        return armLen;
    }

    public void setArmLen(BigDecimal armLen) {
        this.armLen = armLen;
    }

    public BigDecimal getModThigh() {
        return modThigh;
    }

    public void setModThigh(BigDecimal modThigh) {
        this.modThigh = modThigh;
    }

    public BigDecimal getLegLen() {
        return legLen;
    }

    public void setLegLen(BigDecimal legLen) {
        this.legLen = legLen;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}