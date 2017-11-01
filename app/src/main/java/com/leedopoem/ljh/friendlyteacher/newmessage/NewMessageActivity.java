package com.leedopoem.ljh.friendlyteacher.newmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.leedopoem.ljh.friendlyteacher.R;

public class NewMessageActivity extends AppCompatActivity {

    Button backBtn;
    Button okBtn;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
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
