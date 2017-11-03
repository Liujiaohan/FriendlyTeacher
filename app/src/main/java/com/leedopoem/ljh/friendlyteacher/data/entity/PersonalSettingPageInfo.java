package com.leedopoem.ljh.friendlyteacher.data.entity;

import lombok.Data;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
@Data
public class PersonalSettingPageInfo {
    private String uid;
    private String userName;
    private String userSchool;
    private String profession;
    private String grade;
    private String introduction;
    private String signature;

    public PersonalSettingPageInfo(String uid, String userName, String userSchool, String profession, String grade, String introduction, String signature) {
        this.uid = uid;
        this.userName = userName;
        this.userSchool = userSchool;
        this.profession = profession;
        this.grade = grade;
        this.introduction = introduction;
        this.signature = signature;
    }

    public PersonalSettingPageInfo(String userName, String userSchool, String profession, String grade, String introduction, String signature) {
        this.userName = userName;
        this.userSchool = userSchool;
        this.profession = profession;
        this.grade = grade;
        this.introduction = introduction;
        this.signature = signature;
    }
}
