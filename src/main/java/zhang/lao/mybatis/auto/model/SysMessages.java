package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class SysMessages {
    private Integer id;

    private Integer triggerId;

    private Integer targetId;

    private Date createTime;

    private String uuid;

    private Short status;

    private String messageType;

    private Integer messageSourceId;

    private Short isPush;

    private Short isRead;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType == null ? null : messageType.trim();
    }

    public Integer getMessageSourceId() {
        return messageSourceId;
    }

    public void setMessageSourceId(Integer messageSourceId) {
        this.messageSourceId = messageSourceId;
    }

    public Short getIsPush() {
        return isPush;
    }

    public void setIsPush(Short isPush) {
        this.isPush = isPush;
    }

    public Short getIsRead() {
        return isRead;
    }

    public void setIsRead(Short isRead) {
        this.isRead = isRead;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}