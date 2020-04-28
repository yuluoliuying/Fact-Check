package com.ssm.factcheck_ssm.entity;

public class Fact {
    private int Factid;
    private String name;
    private int content;

    public Fact() {
    }

    public Fact(String name, int content) {
        this.name = name;
        this.content = content;
    }

    public int getFactid() {
        return Factid;
    }

    public void setFactid(int Factid) {
        this.Factid = Factid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcontent() {
        return content;
    }

    public void setcontent(int content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "Factid=" + Factid +
                ", name='" + name + '\'' +
                ", content=" + content +
                '}';
    }
}