package com.leedopoem.ljh.friendlyteacher.data.entity;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;

/**
 * Created by ljh on 17-10-2.
 */

public class Lecture extends RealmObject{

    @PrimaryKey
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

    public Lecture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
