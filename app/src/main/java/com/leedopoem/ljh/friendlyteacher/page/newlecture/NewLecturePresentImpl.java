package com.leedopoem.ljh.friendlyteacher.page.newlecture;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.utils.ActivityUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class NewLecturePresentImpl implements NewLectureContract.Presenter {

    private LectureRepository mRepository;

    private NewLectureContract.View mView;

    private CompositeDisposable mCompositeDisposable;

    public NewLecturePresentImpl(NewLectureContract.View view, LectureRepository mRepository) {
        mView = view;
        mView.setPresenter(this);
        this.mRepository = mRepository;
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

        mCompositeDisposable.clear();

    }

    @Override
    public void publishLecture(final Context context) {
        Lecture newLecture = mView.getContentLecture();
        mRepository.publishLecture(newLecture,"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJZb3VTaGktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiIxNTA5NjMzMTQ3MzgwMzcyIiwiYXVkIjoidXNlciIsImV4cCI6MTUxMjQ3NjgxMCwiaWF0IjoxNTA5ODg0ODEwLCJqdGkiOiIxIn0.5VDOGTsiejv6-K3I52-ix5g5PyRJDI1LPpWWYzI-CrU")
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        Log.i("NewLecture", "accept: "+result.getMessage().getResult());
                        ((Activity)context).finish();
                    }
                });
    }

    @Override
    public void confirmBack() {

    }
}
