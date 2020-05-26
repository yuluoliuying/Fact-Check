package com.factcheck.server.model;

import java.util.Date;

public class MessageLog {
    private Integer lid;

    private String username;

    private Date uploadTime;

    private String content;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lid=").append(lid);
        sb.append(", username=").append(username);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}