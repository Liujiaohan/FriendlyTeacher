package com.leedopoem.ljh.friendlyteacher.data.source.local;

import com.leedopoem.ljh.friendlyteacher.base.MyApplication;
import com.leedopoem.ljh.friendlyteacher.data.source.ClassDao;
import com.leedopoem.ljh.friendlyteacher.data.source.DaoSession;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.entity.LectureDao;
import com.leedopoem.ljh.friendlyteacher.utils.RxConverter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-9-27.
 */

public class LectureDaoManager implements ILocalDataSource {
    private DaoSession mDaoSession=null;
    private ClassDao mClassDao;
    private LectureDao mLectureDao;
    private static LectureDaoManager INSTANCE=null;

    public LectureDaoManager() {
        mDaoSession= MyApplication.getINSTANCE().getmDaoSession();
        mClassDao=mDaoSession.getClassDao();
        mLectureDao=mDaoSession.getLectureDao();
    }

    public static synchronized LectureDaoManager getINSTANCE(){
        if (INSTANCE==null){
            INSTANCE=new LectureDaoManager();
        }
        return INSTANCE;
    }


    public Observable<List<Class>> getAllClasses() {
        return RxConverter.convert(mClassDao.loadAll());
    }

    public Observable<Class> getClassById(int id) {
        Class c=null;
        try {
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return RxConverter.convert(c);
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
        return RxConverter.convert(mLectureDao.loadAll());
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUser(String uid) {
        return RxConverter.convert(mLectureDao.queryBuilder().
                where(LectureDao.Properties.Uid.eq(uid)));
    }

    @Override
    public Observable<Boolean> save(List<Lecture> lectures) {
        mLectureDao.insertOrReplaceInTx(lectures);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> save(Lecture lecture) {
        mLectureDao.insertOrReplace(lecture);
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
        mLectureDao.delete(lecture);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> delete(List<Lecture> lectures) {
        mLectureDao.deleteInTx(lectures);
        return RxConverter.convert(true);
    }
}
