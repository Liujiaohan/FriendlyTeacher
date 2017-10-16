package com.leedopoem.ljh.friendlyteacher.data.source.local;

import com.leedopoem.ljh.friendlyteacher.entity.Book;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.entity.User;

import java.util.LinkedHashSet;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ljh on 17-10-2.
 */

public interface ILocalDataSource {
    Observable<List<Lecture>> getAllLectures();
    Observable<List<Lecture>> getLecturesByUser(String uid);
    Observable<Boolean> save(List<Lecture> lectures);
    Observable<Boolean> save(Lecture lecture);
    Observable<Boolean> update(List<Lecture> lectures);
    Observable<Boolean> update(Lecture lecture);
    Observable<Boolean> delete(Lecture lecture);
    Observable<Boolean> delete(List<Lecture> lectures);
}