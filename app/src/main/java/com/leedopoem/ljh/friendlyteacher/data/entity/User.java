package com.leedopoem.ljh.friendlyteacher.data.entity;

import android.util.Log;

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

    @Override
    public String toString() {
          String s="{" +
                "\"uid\" : "+"\"U201617233\", " +
                "\"username\" : " + "\""+username + "\", " +
                "\"email\" : " + "\""+email + "\", " +
                "\"password\" : " +"\""+password +"\", "+
                "\"classInfo\" : " + "\""+classInfo + "\", " +
                "\"introduction\" : " + "\""+introduction + "\"" +
                "}";
          Log.i("TAG", "toString: "+s);
          return s;
    }
}
