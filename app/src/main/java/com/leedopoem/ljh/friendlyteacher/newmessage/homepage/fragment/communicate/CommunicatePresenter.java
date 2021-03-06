package com.leedopoem.ljh.friendlyteacher.newmessage.homepage.fragment.communicate;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ljh on 17-10-30.
 */

public class CommunicatePresenter implements CommunicateContract.Presenter {
    private LectureRepository mRepository;

    private CommunicateContract.View mCommunicatePageView;

    private CompositeDisposable mCompositeDisposable;

    public CommunicatePresenter(LectureRepository repository, CommunicateContract.View communicatePageView) {
        this.mRepository = repository;
        this.mCommunicatePageView = communicatePageView;
        mCommunicatePageView.setPresenter(this);
        mCompositeDisposable=new CompositeDisposable();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void loadLeaveWords() {
//        Disposable disposable=mRepository
//                .getAllLectures()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<LeaveWord>>(){
//                    @Override
//                    public void accept(List<LeaveWord> leaveWords) throws Exception {
//                        mCommunicatePageView.showLeaveWords(leaveWords);
//                    }
//                });
//
//        mCompositeDisposable.add(disposable);
    }

    @Override
    public void addLeaveWords() {

    }

    @Override
    public void openLeaveWordsDetails() {

    }
}
