package com.leedopoem.ljh.friendlyteacher.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import lombok.Data;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ljh on 17-10-2.
 */

@Data
@Entity
public class Lecture {
    @Id(autoincrement = true)
    private Long id;
    private String uid;
    private String lectureName;
    private String location;
    private String startingTime;
    private String endingTime;
    private String classTime;
    private String introduction;

    public Lecture(String uid, String lectureName, String location, String startingTime,
                   String endingTime, String classTime, String introduction) {
        this.uid = uid;
        this.lectureName = lectureName;
        this.location = location;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.classTime = classTime;
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getClassTime() {
        return this.classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getEndingTime() {
        return this.endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getStartingTime() {
        return this.startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLectureName() {
        return this.lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 168659645)
    public Lecture(Long id, String uid, String lectureName, String location,
            String startingTime, String endingTime, String classTime, String introduction) {
        this.id = id;
        this.uid = uid;
        this.lectureName = lectureName;
        this.location = location;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.classTime = classTime;
        this.introduction = introduction;
    }

    @Generated(hash = 637726957)
    public Lecture() {
    }
}
