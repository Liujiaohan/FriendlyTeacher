package com.leedopoem.ljh.friendlyteacher.newlecture;

import android.util.Log;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class NewLecturePresentImpl implements NewLectureContract.Presenter {

    private NewLectureContract.View mView;
    private LectureRepository mRepository;

    public NewLecturePresentImpl(NewLectureContract.View view,LectureRepository repository) {
        mView = view;
        mRepository=repository;
        mView.setPresenter(this);
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void publishLecture() {
        Lecture newLecture = mView.getContentLecture();
        mRepository.publishLecture(newLecture)
                .doOnNext(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        Log.i("NewLecture", "accept: "+result.getMessage().getResult());
                    }
                });
    }

    @Override
    public void confirmBack() {

    }
}
