package com.leedopoem.ljh.friendlyteacher.login;

import android.os.Bundle;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.base.BaseActivity;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private LectureRepository mLectureRepository;

    private LoginContract.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLectureRepository = new LectureRepository(this);
        mPresenter = new LoginPresentImpl(this, mLectureRepository);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void loginError() {

    }

    @Override
    public void loginSuccess() {

    }
}
