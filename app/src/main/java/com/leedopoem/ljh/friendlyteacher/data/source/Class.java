package com.leedopoem.ljh.friendlyteacher.data.source;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.sql.Timestamp;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ljh on 17-9-27.
 */
@Entity
public class Class {
    @Id
    private Long Id;

    private String teacher;

    private String time;

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    @Generated(hash = 1075984576)
    public Class(Long Id, String teacher, String time) {
        this.Id = Id;
        this.teacher = teacher;
        this.time = time;
    }

    @Generated(hash = 1587257007)
    public Class() {
    }
}
