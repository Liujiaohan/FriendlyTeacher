package com.leedopoem.ljh.friendlyteacher.homepage.fragment.recommend;

import android.content.Context;
import android.content.Intent;

import com.leedopoem.ljh.friendlyteacher.base.MyApplication;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;
import com.leedopoem.ljh.friendlyteacher.homepage.HomePageActivity;
import com.leedopoem.ljh.friendlyteacher.newlecture.NewLectureContract;
import com.leedopoem.ljh.friendlyteacher.newlecture.PublishNewLectureActivity;
import com.leedopoem.ljh.friendlyteacher.newmessage.NewMessageActivity;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by ljh on 17-10-3.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private LectureRepository mRepository;

    private RecommendContract.View mHomepageView;

    private CompositeDisposable mCompositeDisposable;

    private Context context;

    public RecommendPresenter(Context context,LectureRepository repository, RecommendContract.View homepageView) {
        this.context=context;
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
        Intent intent=new Intent(context, PublishNewLectureActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void openLectureDetails() {

    }

}
