package com.factcheck.server.model;

import java.util.Date;

public class Result {
    private Integer rid;

    private Integer mid;

    private String username;

    private String resultName;

    private String cover;

    private String position;

    private String tagName;

    private Date updateTime;

    private Date releaseTime;

    private String description;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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
        sb.append(", rid=").append(rid);
        sb.append(", mid=").append(mid);
        sb.append(", username=").append(username);
        sb.append(", resultName=").append(resultName);
        sb.append(", cover=").append(cover);
        sb.append(", position=").append(position);
        sb.append(", tagName=").append(tagName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}