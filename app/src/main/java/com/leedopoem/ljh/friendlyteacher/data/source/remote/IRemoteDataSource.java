package com.leedopoem.ljh.friendlyteacher.data.source.remote;

import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.data.entity.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-10-2.
 */

public interface IRemoteDataSource {

    //用户
    //注册
    Observable<Result> registAsUser(User user);
    //登录
    Observable<Result> login(String uid,String password);
    //修改用户信息
    Observable<Result> alterUserInformation(User user);
    //获得用户信息
    Observable<User> getUserInformation(String uid);

    //课程
    //获得所有课程
    Observable<List<Lecture>> getAllLectures();
    //发布某个课程
    Observable<Result> publishLecture(Lecture lecture,String token);
    //获取用户的某个课程
    Observable<List<Lecture>> getLecturesByUid(String uid);
    //获取某个课程
    Observable<Lecture> getLectureByLid(String lid);
    //删除某个课程
    Observable<Result> deleteLecture(String lid);
    //修改课程信息
    Observable<Result> alterLectureInformation(Lecture lecture);
}
