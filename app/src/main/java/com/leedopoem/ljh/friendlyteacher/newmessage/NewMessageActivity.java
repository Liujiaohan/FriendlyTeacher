package com.leedopoem.ljh.friendlyteacher.newmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.LectureRepository;

import io.reactivex.disposables.CompositeDisposable;

public class NewMessageActivity extends AppCompatActivity {

    private Button backBtn;
    private Button okBtn;
    private EditText edt;
    private LectureRepository mRepository;
    private CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        mRepository = new LectureRepository(this);
        backBtn = (Button) findViewById(R.id.message_back_btn);
        okBtn = (Button) findViewById(R.id.message_finish_btn);
        edt = (EditText) findViewById(R.id.message_edt);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
