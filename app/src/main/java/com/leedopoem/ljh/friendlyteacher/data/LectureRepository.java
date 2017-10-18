package com.leedopoem.ljh.friendlyteacher.data;

import android.content.Context;
import android.util.Log;

import com.leedopoem.ljh.friendlyteacher.data.source.local.ILocalDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.local.LectureLocalDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.IRemoteDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.LectureRemoteDataSource;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.data.entity.User;
import com.leedopoem.ljh.friendlyteacher.utils.NetworkAvailableUtil;
import com.leedopoem.ljh.friendlyteacher.utils.RxConverter;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-9-27.
 */

public class LectureRepository implements ILocalDataSource,IRemoteDataSource {
    private String TAG="LectureRepository";
    private LectureRemoteDataSource mRemoteDataSource;
    private LectureLocalDataSource mLocalDataSource;
    private Boolean netAvailable;
    private Context mContext;

    public LectureRepository(Context context) {
        mLocalDataSource=LectureLocalDataSource.getInstance();
        mRemoteDataSource=LectureRemoteDataSource.getInstance();
        mContext=context;
        netAvailable= NetworkAvailableUtil.isAvailable(context);
    }

    @Override
    public Observable<Result> registAsUser(User user) {
        if (netAvailable){
            return mRemoteDataSource.registAsUser(user);
        }
        else return null;
    }

    @Override
    public Observable<Result> login(String uid, String password) {
        if (netAvailable){
            return mRemoteDataSource.login(uid,password);
        }else{
            Log.i(TAG, "login: "+"网络不可用");
            return null;
        }
    }

    @Override
    public Observable<Result> alterUserInformation(User user) {
        if (netAvailable){
            return mRemoteDataSource.alterUserInformation(user);
        }
        return null;
    }

    @Override
    public Observable<User> getUserInformation(String uid) {
        if (netAvailable){
            return mRemoteDataSource.getUserInformation(uid);
        }
        return null;
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
        if (netAvailable){
            Observable<List<Lecture>> lectures=mRemoteDataSource.getAllLectures();
            mLocalDataSource.save(lectures.blockingSingle());
            return lectures;
        }
        return mLocalDataSource.getAllLectures();
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUser(String uid) {
        if (netAvailable){
            return mRemoteDataSource.getLecturesByUid(uid);
        }
        else{
            return mLocalDataSource.getLecturesByUser(uid);
        }
    }

    @Override
    public Observable<Result> publishLecture(Lecture lecture) {
        if (netAvailable) {
            return mRemoteDataSource.publishLecture(lecture);
        }
        Log.i(TAG, "publishLecture: "+"发布任务失败");
        return null;
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUid(String uid) {
        if (netAvailable){
            return mRemoteDataSource.getLecturesByUid(uid);
        }
        return mLocalDataSource.getLecturesByUser(uid);
    }

    @Override
    public Observable<Lecture> getLectureByLid(String lid) {
        if (netAvailable){
            return mRemoteDataSource.getLectureByLid(lid);
        }
        return null;
    }

    @Override
    public Observable<Result> deleteLecture(String lid) {
        if (netAvailable){
            return mRemoteDataSource.deleteLecture(lid);
        }
        return null;
    }

    @Override
    public Observable<Result> alterLectureInformation(Lecture lecture) {
        if (netAvailable){
            mRemoteDataSource.alterLectureInformation(lecture);
        }
        Log.i(TAG, "alterLectureInformation: "+"修改失败");
        return null;
    }

    @Override
    public Observable<Boolean> save(List<Lecture> lectures) {
        mLocalDataSource.save(lectures);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> save(Lecture lecture) {
        mLocalDataSource.save(lecture);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> update(List<Lecture> lectures) {
        mLocalDataSource.update(lectures);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> update(Lecture lecture) {
        mLocalDataSource.update(lecture);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> delete(Lecture lecture) {
        mLocalDataSource.delete(lecture);
        return RxConverter.convert(true);
    }

    @Override
    public Observable<Boolean> delete(List<Lecture> lectures) {
        mLocalDataSource.delete(lectures);
        return RxConverter.convert(true);
    }
}
