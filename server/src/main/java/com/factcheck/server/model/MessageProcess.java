package com.factcheck.server.model;

public class MessageProcess {
    private Integer processNum;

    private Integer mid;

    private Integer type;

    private Integer state;

    private String username;

    private String content;

    public Integer getProcessNum() {
        return processNum;
    }

    public void setProcessNum(Integer processNum) {
        this.processNum = processNum;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        sb.append(", processNum=").append(processNum);
        sb.append(", mid=").append(mid);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", username=").append(username);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}