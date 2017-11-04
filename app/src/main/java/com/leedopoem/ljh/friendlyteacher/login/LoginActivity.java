package com.leedopoem.ljh.friendlyteacher.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.base.BaseActivity;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.homepage.HomePageActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private LectureRepository mLectureRepository;
    private EditText metEmail,metPass;

    private LoginContract.Presenter mPresenter;

    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLectureRepository = new LectureRepository(this);
        mPresenter = new LoginPresentImpl(this, mLectureRepository);
        loginBtn = (Button) findViewById(R.id.login_btn);
        metEmail= (EditText) findViewById(R.id.editText);
        metPass=(EditText)findViewById(R.id.login_edit_email);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(metEmail.getText().toString(),metPass.getText().toString());

            }
        });
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
