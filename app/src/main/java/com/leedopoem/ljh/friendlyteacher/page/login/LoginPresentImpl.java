package com.leedopoem.ljh.friendlyteacher.page.login;

import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class LoginPresentImpl implements LoginContract.Presenter {

    private LectureRepository mLectureRepository;

    private LoginContract.View mView;

    private CompositeDisposable mCompositeDisposable;

    public LoginPresentImpl(LoginContract.View view, LectureRepository mLectureRepository) {
        mView = view;
        mView.setPresenter(this);
        this.mLectureRepository = mLectureRepository;
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
    public void login(String uid, String passward) {
        Disposable disposable = mLectureRepository
                .login(uid, passward)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        if (result != null) {
                            mView.loginSuccess();
                        } else {
                            mView.loginError();
                        }
                    }
                });
    }
}
