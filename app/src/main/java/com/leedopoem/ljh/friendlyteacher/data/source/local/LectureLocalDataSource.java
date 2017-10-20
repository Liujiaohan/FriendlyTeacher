package com.leedopoem.ljh.friendlyteacher.data.source.local;

import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-9-27.
 */

public class LectureLocalDataSource implements ILocalDataSource {
    private LectureDao lectureDao = LectureDao.getINSTANCE();
    private static LectureLocalDataSource INSTANCE=null;

    public LectureLocalDataSource() {
    }

    public static LectureLocalDataSource getInstance(){
        if (INSTANCE==null){
            INSTANCE=new LectureLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
        return lectureDao.getAllLectures();
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUser(String uid) {
        return lectureDao.getLecturesByUser(uid);
    }

    @Override
    public Observable<Boolean> save(List<Lecture> lectures) {
        return lectureDao.save(lectures);
    }

    @Override
    public Observable<Boolean> save(Lecture lecture) {
        return lectureDao.save(lecture);
    }

    @Override
    public Observable<Boolean> update(List<Lecture> lectures) {
        return lectureDao.update(lectures);
    }

    @Override
    public Observable<Boolean> update(Lecture lecture) {
        return lectureDao.update(lecture);
    }

    @Override
    public Observable<Boolean> delete(Lecture lecture) {
        return lectureDao.delete(lecture);
    }

    @Override
    public Observable<Boolean> delete(List<Lecture> lectures) {
        return lectureDao.delete(lectures);
    }
}
