package com.leedopoem.ljh.friendlyteacher.homepage;

import android.support.annotation.NonNull;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.enums.LectureType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by ljh on 17-10-3.
 */

public class HomePagePresenter implements HomePageContract.Presenter {

    private LectureRepository mRepository;

    private HomePageContract.View mHomepageView;

    private CompositeDisposable mCompositeDisposable;

    public HomePagePresenter(LectureRepository repository, HomePageContract.View homepageView) {
        this.mRepository = repository;
        this.mHomepageView = homepageView;
        mHomepageView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadRecommendLecture();
    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void loadRecommendLecture() {
        mCompositeDisposable.add(mRepository.getAllLectures()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Lecture>>() {
            @Override
            public void accept(List<Lecture> lectures) throws Exception {
                mHomepageView.showLectures(lectures);
            }
        }));
    }

    @Override
    public void loadLectureByType(LectureType lectureType) {
    }

    @Override
    public void publishLecture(Lecture lecture) {
    }

    @Override
    public void communicateModule() {
    }

    @Override
    public void userInformationCenter() {
    }

}
