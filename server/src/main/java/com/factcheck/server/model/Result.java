package com.factcheck.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("根据经过第一次审核的流言写的文章")
public class Result {
    @ApiModelProperty("文章id")
    private Integer rid;
    @ApiModelProperty("相关流言的id")
    private Integer mid;
    @ApiModelProperty("起草人员用户名")
    private String username;
    @ApiModelProperty("文章名")
    private String resultName;
    @ApiModelProperty("封面")
    private String cover;
    @ApiModelProperty("相关地点")
    private String position;
    @ApiModelProperty("标签")
    private String tagName;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("发布时间")
    private Date releaseTime;
    @ApiModelProperty("文章内容")
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