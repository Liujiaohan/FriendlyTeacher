package com.leedopoem.ljh.friendlyteacher.homepage;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
        mCompositeDisposable=new CompositeDisposable();
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
        Disposable disposable=mRepository
                .getAllLectures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Lecture>>(){
                    @Override
                    public void accept(List<Lecture> lectures) throws Exception {
                        mHomepageView.showLectures(lectures);
                    }
                });

        mCompositeDisposable.add(disposable);
    }

    @Override
    public void addNewLecture() {

    }

    @Override
    public void openLectureDetails() {

    }

}
