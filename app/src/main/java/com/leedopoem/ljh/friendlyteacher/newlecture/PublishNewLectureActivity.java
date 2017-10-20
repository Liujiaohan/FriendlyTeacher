package com.leedopoem.ljh.friendlyteacher.newlecture;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

public class PublishNewLectureActivity extends AppCompatActivity implements NewLectureContract.View, View.OnClickListener{

    private NewLectureContract.Presenter mPresenter;
    private Button backBtn;
    private Button finishBtn;
    private EditText classNameEdt;
    private EditText teachPersonEdt;
    private EditText startTimeEdt;
    private EditText startPlaceEdt;
    private EditText lectureTimeEdt;
    private EditText lectureTypeEdt;
    private EditText introductionEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_new_lecture);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        mPresenter = new NewLecturePresentImpl(this);
        init();
    }

    private void init() {
        backBtn = (Button) findViewById(R.id.newlecture_back_btn);
        finishBtn = (Button) findViewById(R.id.newlecture_finish_btn);
        classNameEdt = (EditText) findViewById(R.id.newlecture_classname_edt);
        teachPersonEdt = (EditText) findViewById(R.id.newlecture_teachperson_edi);
        startTimeEdt = (EditText) findViewById(R.id.newlecture_startclasstime_edi);
        startPlaceEdt = (EditText) findViewById(R.id.newlecture_clasplace_edi);
        lectureTimeEdt = (EditText) findViewById(R.id.newlecture_classtime_edi);
        lectureTypeEdt = (EditText) findViewById(R.id.newlecture_classtype_edi);
        introductionEdt = (EditText) findViewById(R.id.newlecture_introduction_edt);
        backBtn.setOnClickListener(this);
        finishBtn.setOnClickListener(this);
    }


    @Override
    public void setPresenter(NewLectureContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showProgressbar() {
        //上传新的课程，显示进度条
    }

    @Override
    public void confirmBack() {
        //是否退出
    }

    @Override
    public Lecture getContentLecture() {

        String className = classNameEdt.getText().toString();
        String teachPerson = teachPersonEdt.getText().toString();
        String classStartTime = startTimeEdt.getText().toString();
        String classPlace = startPlaceEdt.getText().toString();
        String lectureTime = lectureTimeEdt.getText().toString();
        String lectureType = lectureTypeEdt.getText().toString();
        String introduction = introductionEdt.getText().toString();
        //不会获取id和uid
        //不需要授课人？
        Lecture newLecture = new Lecture((long)0, "", className, classStartTime, classPlace, lectureTime, lectureType, introduction);
        return newLecture;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newlecture_back_btn: {
                mPresenter.confirmBack();
                finish();
                break;
            }
            case R.id.newlecture_finish_btn: {
                mPresenter.publishLecture();
                break;
            }
        }
    }
}
