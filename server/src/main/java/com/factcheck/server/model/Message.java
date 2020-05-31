package com.factcheck.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("流言")
public class Message {
    @ApiModelProperty("流言id")
    private Integer mid;
    @ApiModelProperty("流言标题（名）")
    private String messageName;
    @ApiModelProperty("上传流言用户名")
    private String username;
    @ApiModelProperty("封面")
    private String cover;
    @ApiModelProperty("相关地点")
    private String position;
    @ApiModelProperty("标签")
    private String tagName;
    @ApiModelProperty("上传时间")
    private Date uploadTime;
    @ApiModelProperty("流言内容（描述）")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        sb.append(", username=").append(username);
        sb.append(", cover=").append(cover);
        sb.append(", position=").append(position);
        sb.append(", tagName=").append(tagName);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}