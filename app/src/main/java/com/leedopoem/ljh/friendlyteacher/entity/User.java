package com.leedopoem.ljh.friendlyteacher.entity;

import com.leedopoem.ljh.friendlyteacher.enums.Gender;

import lombok.Data;

/**
 * Created by ljh on 17-9-27.
 */

@Data
public class User {
    private String uid;
    private String username;
    private String email;
    private String password;
    private String classInfo;
    private String introduction;

    public User(String uid, String username, String email, String password,
                String classInfo, String introduction) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.classInfo = classInfo;
        this.introduction = introduction;
    }
}
