package com.cy.store.entity;

import java.util.Date;

public class Design {
    Integer did;
    Integer uid;
    String style;
    String area;
    String layout;
    String budget;
    String phone;
    String intro;
    Date createdTime;
    Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Design)) return false;

        Design design = (Design) o;

        if (getDid() != null ? !getDid().equals(design.getDid()) : design.getDid() != null) return false;
        if (getUid() != null ? !getUid().equals(design.getUid()) : design.getUid() != null) return false;
        if (getStyle() != null ? !getStyle().equals(design.getStyle()) : design.getStyle() != null) return false;
        if (getArea() != null ? !getArea().equals(design.getArea()) : design.getArea() != null) return false;
        if (getLayout() != null ? !getLayout().equals(design.getLayout()) : design.getLayout() != null) return false;
        if (getBudget() != null ? !getBudget().equals(design.getBudget()) : design.getBudget() != null) return false;
        if (getPhone() != null ? !getPhone().equals(design.getPhone()) : design.getPhone() != null) return false;
        if (getIntro() != null ? !getIntro().equals(design.getIntro()) : design.getIntro() != null) return false;
        if (getCreatedTime() != null ? !getCreatedTime().equals(design.getCreatedTime()) : design.getCreatedTime() != null)
            return false;
        return getStatus() != null ? getStatus().equals(design.getStatus()) : design.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getDid() != null ? getDid().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getStyle() != null ? getStyle().hashCode() : 0);
        result = 31 * result + (getArea() != null ? getArea().hashCode() : 0);
        result = 31 * result + (getLayout() != null ? getLayout().hashCode() : 0);
        result = 31 * result + (getBudget() != null ? getBudget().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getIntro() != null ? getIntro().hashCode() : 0);
        result = 31 * result + (getCreatedTime() != null ? getCreatedTime().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Design{" +
                "did=" + did +
                ", uid=" + uid +
                ", style='" + style + '\'' +
                ", area='" + area + '\'' +
                ", layout='" + layout + '\'' +
                ", budget='" + budget + '\'' +
                ", phone='" + phone + '\'' +
                ", intro='" + intro + '\'' +
                ", createdTime=" + createdTime +
                ", status=" + status +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
