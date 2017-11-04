package com.leedopoem.ljh.friendlyteacher.data.source.remote;

import com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit.ApiServiceManager;
import com.leedopoem.ljh.friendlyteacher.data.entity.Book;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.data.entity.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-9-28.
 */

public class LectureRemoteDataSource implements IRemoteDataSource {
    private ApiServiceManager apiServiceManager;
    private static LectureRemoteDataSource INSTANCE;

    public static LectureRemoteDataSource getInstance(){
        if (INSTANCE==null){
            INSTANCE=new LectureRemoteDataSource();
        }
        return INSTANCE;
    }
    @Override
    public Observable<List<Lecture>> getAllLectures() {
        return apiServiceManager.getAllLectures();
    }

    public LectureRemoteDataSource() {
        apiServiceManager=new ApiServiceManager();
    }

    public Observable<Book> getBook(){
        return apiServiceManager.getSearchBook();
    }


    @Override
    public Observable<Result> registAsUser(User user) {
        return apiServiceManager.registAsUser(user);
    }

    @Override
    public Observable<Result> login(String uid, String password) {
        return apiServiceManager.login(uid,password);
    }

    @Override
    public Observable<Result> alterUserInformation(User user) {
        return apiServiceManager.alterUserInformation(user);
    }

    @Override
    public Observable<User> getUserInformation(String uid) {
        return apiServiceManager.getUserInformation(uid);
    }

    @Override
    public Observable<Result> publishLecture(Lecture lecture,String token) {
        return apiServiceManager.publishLecture(lecture,token);
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUid(String uid) {
        return apiServiceManager.getLecturesByUid(uid);
    }

    @Override
    public Observable<Lecture> getLectureByLid(String lid) {
        return apiServiceManager.getLectureByLid(lid);
    }

    @Override
    public Observable<Result> deleteLecture(String lid) {
        return apiServiceManager.deleteLecture(lid);
    }

    @Override
    public Observable<Result> alterLectureInformation(Lecture lecture) {
        return apiServiceManager.alterLectureInformation(lecture);
    }
}
