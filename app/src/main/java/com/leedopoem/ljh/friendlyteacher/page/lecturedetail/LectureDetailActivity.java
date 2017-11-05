package com.leedopoem.ljh.friendlyteacher.page.lecturedetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LectureDetailActivity extends AppCompatActivity {

    TextView tvLectureName;

    TextView tvLectureTeacher;

    TextView tvLectureBeginTime;

    TextView tvLectureClassTime;

    TextView tvLectureType;

    TextView tvLectureIntroduction;

    TextView tvLectureLocation;

    Button btnJoin,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);
        Intent intent=getIntent();
        Lecture lecture= (Lecture) intent.getSerializableExtra("lecture");
        tvLectureName= (TextView) findViewById(R.id.tv_lecture_detail_name);
        tvLectureBeginTime= (TextView) findViewById(R.id.tv_lecture_detail_begin_time);
        tvLectureType= (TextView) findViewById(R.id.tv_lecture_detail_class_type);
        tvLectureClassTime= (TextView) findViewById(R.id.tv_lecture_detail_class_time);
        tvLectureTeacher= (TextView) findViewById(R.id.tv_lecture_detail_teacher);
        tvLectureIntroduction= (TextView) findViewById(R.id.tv_lecture_detail_class_introduction);
        tvLectureLocation= (TextView) findViewById(R.id.tv_lecture_detail_location);
        btnBack= (Button) findViewById(R.id.message_detail_back_btn);
        btnJoin= (Button) findViewById(R.id.btn_join_lecture);

        tvLectureName.setText(lecture.getLectureName());
        tvLectureBeginTime.setText("2017-6-1~2017-9-1");
        tvLectureClassTime.setText(lecture.getClassTime());
        tvLectureTeacher.setText("杜恩博");
        tvLectureType.setText("编程");
        tvLectureLocation.setText(lecture.getLocation());
        tvLectureIntroduction.setText(lecture.getIntroduction());
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LectureDetailActivity.this,"加入成功",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
