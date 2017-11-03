package com.leedopoem.ljh.friendlyteacher.page.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.base.BaseActivity;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;
import com.leedopoem.ljh.friendlyteacher.newmessage.homepage.HomePageActivity;
import com.leedopoem.ljh.friendlyteacher.page.findpassword.FindPasswordActivity;
import com.leedopoem.ljh.friendlyteacher.page.zhuce.ZhuceActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private LectureRepository mLectureRepository;

    private LoginContract.Presenter mPresenter;

    private Button loginBtn;
    private TextView zhuceText;
    private TextView findPasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLectureRepository = new LectureRepository(this);
        mPresenter = new LoginPresentImpl(this, mLectureRepository);
        loginBtn = (Button) findViewById(R.id.login_btn);
        zhuceText = (TextView) findViewById(R.id.login_text_zhuce);
        findPasswordText = (TextView) findViewById(R.id.login_text_findpassword);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
        zhuceText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ZhuceActivity.class);
                startActivity(intent);
            }
        });
        findPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FindPasswordActivity.class);
                startActivity(intent);
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
