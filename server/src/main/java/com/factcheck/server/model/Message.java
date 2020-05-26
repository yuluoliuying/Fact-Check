package com.factcheck.server.model;

import java.util.Date;

public class Message {
    private Integer mid;

    private String messageName;

    private String position;

    private String tagName;

    private Date uploadTime;

    private String description;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mid=").append(mid);
        sb.append(", messageName=").append(messageName);
        sb.append(", position=").append(position);
        sb.append(", tagName=").append(tagName);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}