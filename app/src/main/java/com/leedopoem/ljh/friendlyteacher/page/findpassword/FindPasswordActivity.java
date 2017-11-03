package com.leedopoem.ljh.friendlyteacher.page.findpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;

public class FindPasswordActivity extends AppCompatActivity {

    private Button backBtn;
    private Button okBtn;
    private EditText emailEdt;
    private EditText nameEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
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
                //// TODO: 2017/11/3 0003 找回密码 
            }
        });
    }

    private void init() {
        backBtn = (Button) findViewById(R.id.findpassword_btn_back);
        okBtn = (Button) findViewById(R.id.findpassword_btn_ok);
        emailEdt = (EditText) findViewById(R.id.findpassword_edt_email);
        nameEdt = (EditText) findViewById(R.id.findpassword_edt_name);
    }
    
}
