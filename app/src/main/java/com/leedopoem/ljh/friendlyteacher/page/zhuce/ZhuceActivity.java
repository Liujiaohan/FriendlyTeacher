package com.leedopoem.ljh.friendlyteacher.page.zhuce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;

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
