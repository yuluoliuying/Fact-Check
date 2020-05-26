package com.factcheck.server.model;

import java.util.Date;

public class Result {
    private Integer rid;

    private Integer state;

    private String resultName;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
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
        sb.append(", state=").append(state);
        sb.append(", resultName=").append(resultName);
        sb.append(", position=").append(position);
        sb.append(", tagName=").append(tagName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}