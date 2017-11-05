package com.leedopoem.ljh.friendlyteacher.lecturedetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.Lecture;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LectureDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_lecture_detail_name)
    TextView tvLectureName;
    @BindView(R.id.tv_lecture_detail_teacher)
    TextView tvLectureTeacher;
    @BindView(R.id.tv_lecture_detail_begin_time)
    TextView tvLectureBeginTime;
    @BindView(R.id.tv_lecture_detail_class_introduction)
    TextView tvLectureClassTime;
    @BindView(R.id.tv_lecture_detail_class_type)
    TextView tvLectureType;
    @BindView(R.id.btn_join_lecture)
    Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_detail);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        Lecture lecture= (Lecture) intent.getSerializableExtra("lecture");
        tvLectureName.setText(lecture.getLectureName());
        tvLectureBeginTime.setText("2017-6-1~2017-9-1");
        tvLectureClassTime.setText(lecture.getClassTime());
        tvLectureTeacher.setText("杜恩博");
        tvLectureType.setText("编程");
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LectureDetailActivity.this,"加入成功",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
