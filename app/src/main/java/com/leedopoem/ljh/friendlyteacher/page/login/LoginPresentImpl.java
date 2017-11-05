package com.leedopoem.ljh.friendlyteacher.page.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.leedopoem.ljh.friendlyteacher.base.MyApplication;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.data.entity.Result;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.HomePageActivity;

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
    public void login(String uid, String password) {
        Log.i("TAG", "login: "+uid+"  "+password);
        Disposable disposable = mLectureRepository
                .login(uid, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        if (result.getMessage().getResult().equals("登录成功")) {
                            mView.loginSuccess();
                            SharedPreferences sharedPreferences=MyApplication.getINSTANCE().getSharedPreferences("auth", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            Intent intent = new Intent(MyApplication.getContext(), HomePageActivity.class);
                            MyApplication.getINSTANCE().startActivity(intent);
                        } else {
                            Toast.makeText(MyApplication.getINSTANCE(),"密码错误",Toast.LENGTH_LONG).show();
                            mView.loginError();
                        }
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
