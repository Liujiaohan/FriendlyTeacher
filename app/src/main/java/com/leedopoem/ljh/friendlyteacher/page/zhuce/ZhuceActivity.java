package com.leedopoem.ljh.friendlyteacher.page.zhuce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;
import com.leedopoem.ljh.friendlyteacher.data.entity.PersonalInfo;

public class ZhuceActivity extends AppCompatActivity {
    private Button backBtn;
    private Button okBtn;
    //学号
    private EditText uidEdt;
    private EditText usernameEdt;
    private EditText emailEdt;
    private EditText passwordEdt;
    private EditText professionEdt;
    private EditText gradeEdt;
    private EditText signatureEdt;
    private EditText intruductionEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
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
                PersonalInfo info = new PersonalInfo(
                        uidEdt.getText().toString(),
                        usernameEdt.getText().toString(),
                        emailEdt.getText().toString(),
                        passwordEdt.getText().toString(),
                        professionEdt.getText().toString(),
                        gradeEdt.getText().toString(),
                        signatureEdt.getText().toString(),
                        intruductionEdt.getText().toString()
                );
                //// TODO: 2017/11/3 0003 注册 
            }
        });
    }

    private void init() {
        backBtn = (Button) findViewById(R.id.zhuce_btn_back);
        okBtn = (Button) findViewById(R.id.zhuce_btn_ok);
        uidEdt = (EditText) findViewById(R.id.zhuce_edt_xuehao);
        usernameEdt = (EditText) findViewById(R.id.zhuce_edt_name);
        emailEdt = (EditText) findViewById(R.id.zhuce_edt_email);
        passwordEdt = (EditText) findViewById(R.id.zhuce_edt_password);
        professionEdt = (EditText) findViewById(R.id.zhuce_edt_profession);
        gradeEdt = (EditText) findViewById(R.id.zhuce_edt_grade);
        signatureEdt = (EditText) findViewById(R.id.zhuce_edt_signature);
        intruductionEdt = (EditText) findViewById(R.id.zhuce_edt_introduction);
    }
}
