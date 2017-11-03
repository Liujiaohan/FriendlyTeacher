package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.personal;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Administrator on 2017/11/2 0002.
 */

public class PersonalPresenter implements PersonalConstract.Presenter {

    private LectureRepository mRepository;

    private PersonalConstract.View mPersonalView;

    private CompositeDisposable mCompositeDisposable;


    public PersonalPresenter(LectureRepository repository, PersonalConstract.View mPersonalView) {
        this.mRepository = repository;
        this.mPersonalView = mPersonalView;
        mPersonalView.setPresenter(this);
        mCompositeDisposable=new CompositeDisposable();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void loadPersenalInfo() {
        // TODO: 2017/11/2 0002 等后台接口


        //mPersonalView.showPersonalInfo();
    }
}
