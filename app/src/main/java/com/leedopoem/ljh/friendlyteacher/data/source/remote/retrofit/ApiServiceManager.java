package com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit;

import com.google.gson.GsonBuilder;
import com.leedopoem.ljh.friendlyteacher.data.entity.Book;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.data.entity.User;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.IRemoteDataSource;
import com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit.api.LectureService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ljh on 17-9-28.
 */

public class ApiServiceManager implements IRemoteDataSource{
    public Retrofit retrofit;
    public LectureService lectureService;
    public ApiServiceManager() {
        retrofit=new Retrofit.Builder()
                .baseUrl("http://188.166.235.146:8080/spittr/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        lectureService=retrofit.create(LectureService.class);
    }

    public Observable<Book> getSearchBook(){
        return lectureService.getSearchBook("金瓶梅",null,0,1);
    }


    @Override
    public Observable<Result> registAsUser(User user) {
        return lectureService.registAsUser(RequestBody
                .create(MediaType.parse("application/json"),toString()))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Result> login(String uid, String password) {
        return lectureService.login(uid,password).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Result> alterUserInformation(User user) {
        return lectureService.alterUserInformation(user.getUid(),RequestBody
                .create(MediaType.parse("application/json"),toString()))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<User> getUserInformation(String uid) {
        return lectureService.getUserInformation(uid).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<Lecture>> getAllLectures() {
        Observable<List<Lecture>> list=null;
        try {
            list=lectureService.getAllLectures().subscribeOn(Schedulers.io());
        }catch (Exception e){
            ExceptionHandler.handleException(e);
        }
        return list;
    }

    @Override
    public Observable<Result> publishLecture(Lecture lecture,String token) {
        try {

            return lectureService.publishLecture(RequestBody.create(MediaType.parse("application/json")
                    ,lecture.toString()),token).subscribeOn(Schedulers.io());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return null;
    }

    @Override
    public Observable<List<Lecture>> getLecturesByUid(String uid) {
        return lectureService.getLecturesByUid(uid).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Lecture> getLectureByLid(String lid) {
        return lectureService.getLectureByLid(lid).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Result> deleteLecture(String lid) {
        return lectureService.deleteLecture(lid).subscribeOn(Schedulers.io());
    }

    //注意 此为测试
    @Override
    public Observable<Result> alterLectureInformation(Lecture lecture) {
        return lectureService.alterLectureInformation("1",RequestBody
                .create(MediaType.parse("application/json"),toString()))
                .subscribeOn(Schedulers.io());
    }
}