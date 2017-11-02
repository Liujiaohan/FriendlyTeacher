package com.leedopoem.ljh.friendlyteacher.data.entity;

import lombok.Data;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Data
public class PersonalInfo {
    private int NoticedNum;
    private int FansNum;
    private int PublishedLectureNum;
    private int StudingLectureNum;
    private int CollectedLectureNum;

    public PersonalInfo(int noticedNum, int fansNum, int publishedLectureNum, int studingLectureNum, int collectedLectureNum) {
        NoticedNum = noticedNum;
        FansNum = fansNum;
        PublishedLectureNum = publishedLectureNum;
        StudingLectureNum = studingLectureNum;
        CollectedLectureNum = collectedLectureNum;
    }

}
