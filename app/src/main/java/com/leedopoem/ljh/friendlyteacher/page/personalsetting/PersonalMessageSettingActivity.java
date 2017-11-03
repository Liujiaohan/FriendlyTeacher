package com.leedopoem.ljh.friendlyteacher.page.personalsetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.PersonalSettingPageInfo;

public class PersonalMessageSettingActivity extends AppCompatActivity {

    private Button backBtn;
    private Button okBtn;
    private ImageView touxiangImg;
    private EditText userNameEdt;
    private EditText schoolEdt;
    private EditText professionEdt;
    private EditText gradeEdt;
    private EditText introduction;
    private EditText signatureEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_message_setting);
        init();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalSettingPageInfo info = new PersonalSettingPageInfo(
                        userNameEdt.getText().toString(),
                        schoolEdt.getText().toString(),
                        professionEdt.getText().toString(),
                        gradeEdt.getText().toString(),
                        introduction.getText().toString(),
                        signatureEdt.getText().toString()
                );
                // TODO: 2017/11/3 0003 提交info 
            }
        });
    }

    private void init() {
        backBtn = (Button) findViewById(R.id.detail_message_back_btn);
        okBtn = (Button) findViewById(R.id.detail_message_finish_btn);
        touxiangImg = (ImageView) findViewById(R.id.detail_message_img_touxiang);
        userNameEdt = (EditText) findViewById(R.id.detail_message_edt_username);
        schoolEdt = (EditText) findViewById(R.id.detail_message_edt_user_school);
        professionEdt = (EditText) findViewById(R.id.detail_message_profession);
        gradeEdt = (EditText) findViewById(R.id.detail_message_grade);
        introduction = (EditText) findViewById(R.id.detail_message_edt_introduction);
        signatureEdt = (EditText) findViewById(R.id.detail_message_signature);
    }
}
