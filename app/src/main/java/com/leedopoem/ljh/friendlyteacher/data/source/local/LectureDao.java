package com.leedopoem.ljh.friendlyteacher.data.source.local;

import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.utils.RxConverter;

import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by ljh on 17-9-27.
 */

public class LectureDao implements ILocalDataSource {
//    private DaoSession mDaoSession=null;
//    private LectureDao mLectureDao;
    private static LectureDao INSTANCE=null;
    private static Realm realm=Realm.getDefaultInstance();

    public static synchronized LectureDao getINSTANCE(){
        if (INSTANCE==null){
            INSTANCE=new LectureDao();
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
//        return RxConverter.convert(mLectureDao.loadAll());
        return RxConverter.convert(realm.where(Lecture.class).findAll());
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUser(String uid) {
        return RxConverter.convert(realm.where(Lecture.class).equalTo("uid",uid));
 //       return null;
    }

    @Override
    public Observable<Boolean> save(List<Lecture> lectures) {
//        mLectureDao.insertOrReplaceInTx(lectures);
        realm.beginTransaction();
        realm.copyToRealm(lectures);
        realm.commitTransaction();
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> save(Lecture lecture) {
//        mLectureDao.insertOrReplace(lecture);
        realm.beginTransaction();
        realm.copyToRealm(lecture);
        realm.commitTransaction();
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> update(List<Lecture> lectures) {
        save(lectures);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> update(Lecture lecture) {
        save(lecture);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> delete(Lecture lecture) {
//        mLectureDao.delete(lecture);
        lecture.deleteFromRealm();
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> delete(List<Lecture> lectures) {
//        mLectureDao.deleteInTx(lectures);
        for (Lecture l:lectures
             ) {
            l.deleteFromRealm();
        }
        return RxConverter.convert(true);
    }
}
