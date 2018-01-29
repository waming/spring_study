package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    private long u_id;
    private Integer role_id;
    private String telephone;
    private String username;
    private String userpass;
    private String company_name;
    private Integer check_status;
    private String source;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;

    public long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Integer getCheck_status() {
        return check_status;
    }

    public void setCheck_status(Integer check_status) {
        this.check_status = check_status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", role_id=" + role_id +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", company_name='" + company_name + '\'' +
                ", check_status=" + check_status +
                ", source='" + source + '\'' +
                ", update_time='" + update_time + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
