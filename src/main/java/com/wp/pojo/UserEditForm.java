package com.wp.pojo;

import lombok.Data;

@Data
public class UserEditForm {
    private String login;
    private String name;
    private String password;
    private String post;
    private String degrees;
    private String academicTitle;
    private String cathedra;

    @Override
    public String toString() {
        return "UserEditForm{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", post='" + post + '\'' +
                ", degrees='" + degrees + '\'' +
                ", academicTitle='" + academicTitle + '\'' +
                ", cathedra='" + cathedra + '\'' +
                '}';
    }
}
