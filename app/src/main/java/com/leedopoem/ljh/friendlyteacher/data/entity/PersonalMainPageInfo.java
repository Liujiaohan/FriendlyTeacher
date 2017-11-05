package com.leedopoem.ljh.friendlyteacher.data.entity;

import lombok.Data;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Data
public class PersonalMainPageInfo {
    private String userName;
    private String introduction;
    private int noticedNum;
    private int fansNum;
    private int publishedLectureNum;
    private int studingLectureNum;
    private int collectedLectureNum;

    public PersonalMainPageInfo(String userName, String introduction, int noticedNum, int fansNum, int publishedLectureNum, int studingLectureNum, int collectedLectureNum) {
        this.userName = userName;
        this.introduction = introduction;
        this.noticedNum = noticedNum;
        this.fansNum = fansNum;
        this.publishedLectureNum = publishedLectureNum;
        this.studingLectureNum = studingLectureNum;
        this.collectedLectureNum = collectedLectureNum;
    }
}
