package com.leedopoem.ljh.friendlyteacher.data.source.local;

import com.leedopoem.ljh.friendlyteacher.data.ILectureDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.Class;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.entity.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-9-27.
 */

public class LectureLocalDataSource implements ILocalDataSource {
    private LectureDaoManager lectureDaoManager= LectureDaoManager.getINSTANCE();
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
    public Observable<List<Lecture>> getAllLecture() {
        return lectureDaoManager.getAllLecture();
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUser(String uid) {
        return lectureDaoManager.getLecturesByUser(uid);
    }

    @Override
    public Observable<Boolean> save(List<Lecture> lectures) {
        return lectureDaoManager.save(lectures);
    }

    @Override
    public Observable<Boolean> save(Lecture lecture) {
        return lectureDaoManager.save(lecture);
    }

    @Override
    public Observable<Boolean> update(List<Lecture> lectures) {
        return lectureDaoManager.update(lectures);
    }

    @Override
    public Observable<Boolean> update(Lecture lecture) {
        return lectureDaoManager.update(lecture);
    }

    @Override
    public Observable<Boolean> delete(Lecture lecture) {
        return lectureDaoManager.delete(lecture);
    }

    @Override
    public Observable<Boolean> delete(List<Lecture> lectures) {
        return lectureDaoManager.delete(lectures);
    }
}
